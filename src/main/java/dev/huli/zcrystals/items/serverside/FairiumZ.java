package dev.huli.zcrystals.items.serverside;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import dev.huli.zcrystals.util.ZCrystalsServerSide;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.Nullable;

public class FairiumZ extends SimplePolymerItem {
    PolymerModelData modelData;

    public FairiumZ(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return super.getPolymerItem(itemStack, player);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        this.modelData = ZCrystalsServerSide.fairiumZModelData;
        return this.modelData.value();
    }


    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        if (livingEntity instanceof PokemonEntity pokemonEntity) {
            if (pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("tapu koko")
                    || pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("tapu lele")
                    || pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("tapu bulu")
                    || pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("tapu fini")) {
                itemStack.decrement(1);
                playerEntity.giveItemStack(new ItemStack(ZCrystalsServerSide.TAPUNIUM_Z));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
