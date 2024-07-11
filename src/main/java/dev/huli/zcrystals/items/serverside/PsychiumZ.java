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
        this.modelData = ZCrystalsServerSide.psychiumZModelData;
        return this.modelData.value();
    }


    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        if(livingEntity instanceof PokemonEntity pokemonEntity){
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("lunala")){
                itemStack.decrement(1);
                playerEntity.giveItemStack(new ItemStack(ZCrystalsServerSide.LUNALIUM_Z));
                return ActionResult.SUCCESS;
            }
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("solgaleo")){
                itemStack.decrement(1);
                playerEntity.giveItemStack(new ItemStack(ZCrystalsServerSide.SOLGANIUM_Z));
                return ActionResult.SUCCESS;
            }
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("mew")){
                itemStack.decrement(1);
                playerEntity.giveItemStack(new ItemStack(ZCrystalsServerSide.MEWNIUM_Z));
                return ActionResult.SUCCESS;
            }
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("necrozma")){
                itemStack.decrement(1);
                playerEntity.giveItemStack(new ItemStack(ZCrystalsServerSide.ULTRANECROZIUM_Z));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
