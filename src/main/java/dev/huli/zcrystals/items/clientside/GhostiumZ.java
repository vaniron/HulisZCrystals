package dev.huli.zcrystals.items.clientside;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import dev.huli.zcrystals.util.ZCrystalsClientSide;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class GhostiumZ extends Item {
    
    public GhostiumZ(Settings settings){
        super(settings);
    }


    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        if(livingEntity instanceof PokemonEntity pokemonEntity){
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("marshadow")){
                itemStack.decrement(1);
                playerEntity.giveItemStack(new ItemStack(ZCrystalsClientSide.MARSHADIUM_Z));
                return ActionResult.SUCCESS;
            }
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("mimikyu")){
                itemStack.decrement(1);
                playerEntity.giveItemStack(new ItemStack(ZCrystalsClientSide.MIMIKIUM_Z));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
