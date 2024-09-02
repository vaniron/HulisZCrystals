package dev.huli.zcrystals.items;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import dev.huli.zcrystals.util.ZCrystalItems;
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

public class PsychiumZ extends SimplePolymerItem {
    PolymerModelData modelData;
    public PsychiumZ(Settings settings, Item polymerItem){
        super(settings, polymerItem);
    }
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        return super.getPolymerItem(itemStack,player);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        this.modelData = ZCrystalItems.psychiumZModelData;
        return this.modelData.value();
    }


    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        if(livingEntity instanceof PokemonEntity pokemonEntity && !playerEntity.isSneaking()){
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("lunala")){
                playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.LUNALIUM_Z));
                return ActionResult.SUCCESS;
            }
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("solgaleo")){
                playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.SOLGANIUM_Z));
                return ActionResult.SUCCESS;
            }
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("mew")){
                playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.MEWNIUM_Z));
                return ActionResult.SUCCESS;
            }
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("necrozma")){
                playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.ULTRANECROZIUM_Z));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
