package dev.huli.zcrystals.items.clientside;

import com.cobblemon.mod.common.Cobblemon;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ZRing extends Item {
    public ZRing(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if(!world.isClient){

        if (Cobblemon.INSTANCE.getPlayerData().get(playerEntity).getKeyItems().contains(new Identifier("cobblemon:z_ring"))) {
            playerEntity.sendMessage(Text.literal("You already have the ability to use Z-Moves!").formatted(Formatting.RED), true);
            return TypedActionResult.fail(playerEntity.getStackInHand(hand));
        } else {
            Cobblemon.INSTANCE.getPlayerData().get(playerEntity).getKeyItems().add(new Identifier("cobblemon:z_ring"));
            playerEntity.sendMessage(Text.literal("You obtained the ability to use Z-Moves!").formatted(Formatting.GREEN), true);
            playerEntity.getStackInHand(hand).decrement(1);
            return TypedActionResult.success(playerEntity.getStackInHand(hand));
        }
        }
        else {
            return TypedActionResult.pass(playerEntity.getStackInHand(hand));
        }
    }
}
