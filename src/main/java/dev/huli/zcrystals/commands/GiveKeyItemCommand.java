package dev.huli.zcrystals.commands;


import com.cobblemon.mod.common.Cobblemon;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.huli.zcrystals.ZCrystals;
import dev.huli.zcrystals.permissions.CobbleTransformationsPermissions;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Random;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class GiveKeyItemCommand {
    /**
     * Registers the command with the command dispatcher.
     *
     * @param dispatcher - the command dispatcher.
     */
    public void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        // Set up command.
        dispatcher.register(
                literal("keyitem")
                        .requires(src -> CobbleTransformationsPermissions.checkPermission(src,
                                ZCrystals.permissions.Z_RING_PERMISSION_LEVEL))
                        .then(argument("player", EntityArgumentType.player())
                        .then(argument("keyItem", StringArgumentType.string())
                                .suggests((((context, builder) -> {
                                    builder.suggest("ZRing");
                                    return builder.buildFuture();
                                })))
                                .executes(this::execute)
                        )
                        )
        );

    }



    private int execute(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        String keyItem = StringArgumentType.getString(ctx,"keyItem");
        ServerPlayerEntity player = EntityArgumentType.getPlayer(ctx,"player");
        if (player != null) {
            switch (keyItem){
                case "ZRing":
                    Cobblemon.playerData.get(player).getKeyItems().add(new Identifier("cobblemon:z_ring"));
                    break;
            }

        }
        return 1;
    }

}
