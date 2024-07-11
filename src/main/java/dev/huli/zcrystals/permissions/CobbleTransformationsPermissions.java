package dev.huli.zcrystals.permissions;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.permission.CobblemonPermission;
import com.cobblemon.mod.common.api.permission.PermissionLevel;
import dev.huli.zcrystals.ZCrystals;
import net.minecraft.command.CommandSource;

public class CobbleTransformationsPermissions {

    public final CobblemonPermission Z_RING_PERMISSION_LEVEL;

    public CobbleTransformationsPermissions() {
        this.Z_RING_PERMISSION_LEVEL = new CobblemonPermission("cobbletransformations.command.megaevolve", toPermLevel(ZCrystals.config.cobbleTransformationsConfigDataManager.Z_RING_PERMISSION_LEVEL));
}

    public PermissionLevel toPermLevel(int permLevel) {
        for (PermissionLevel value : PermissionLevel.values()) {
            if (value.ordinal() == permLevel) {
                return value;
            }
        }
        return PermissionLevel.CHEAT_COMMANDS_AND_COMMAND_BLOCKS;
    }

    public static boolean checkPermission(CommandSource source, CobblemonPermission permission) {
        return Cobblemon.INSTANCE.getPermissionValidator().hasPermission(source, permission);
    }
}
