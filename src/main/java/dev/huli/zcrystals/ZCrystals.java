package dev.huli.zcrystals;

import com.mojang.brigadier.CommandDispatcher;
import dev.huli.zcrystals.commands.GiveKeyItemCommand;
import dev.huli.zcrystals.config.CobbleTransformationsConfig;
import dev.huli.zcrystals.permissions.CobbleTransformationsPermissions;
import dev.huli.zcrystals.util.BattleItemUtil;
import dev.huli.zcrystals.util.ZCrystalItems;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.command.ServerCommandSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ZCrystals implements ModInitializer
{
    public final static String MOD_ID = "zcrystals";
    public final static String MOD_NAME = "ZCrystalItems";
    public final static Logger log = LogManager.getLogger(MOD_NAME);
    public static CobbleTransformationsConfig config;
    public static CobbleTransformationsPermissions permissions;


    public static File configDir;

    @Override
    public void onInitialize()
    {
        config = new CobbleTransformationsConfig();
        permissions = new CobbleTransformationsPermissions();
        reload();

        PolymerResourcePackUtils.markAsRequired();
        var isModValid = PolymerResourcePackUtils.addModAssets(MOD_ID);
        // Z-Crystals
        ZCrystalItems.requestModel();
        ZCrystalItems.registerItemGroup();

        // Register Battle Items
        BattleItemUtil.registerHeldItems();


        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                                                           registerCommands(dispatcher));
        ServerLifecycleEvents.SERVER_STARTED.register((minecraftServer) -> reload());

    }

    private void reload() {
        initDirs();
        initConfigs();
    }

    private void initDirs() {
        configDir = FabricLoader.getInstance().getConfigDir().resolve("zcrystals").toFile();
        configDir.mkdirs();
    }

    private void initConfigs() {
        CobbleTransformationsConfig.writeConfig();
        config = CobbleTransformationsConfig.getConfig();
        CobbleTransformationsConfig.updateConfig(config);
    }


    private void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
       GiveKeyItemCommand.register(dispatcher);
    }
}
