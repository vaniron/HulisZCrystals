package dev.huli.zcrystals.items.clientside;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import dev.huli.zcrystals.util.ZCrystalsClientSide;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class RockiumZ extends Item {
    public RockiumZ(Settings settings){
        super(settings);
    }


    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        if(livingEntity instanceof PokemonEntity pokemonEntity){
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("lycanroc")){
                itemStack.decrement(1);
                playerEntity.giveItemStack(new ItemStack(ZCrystalsClientSide.LYCANIUM_Z));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
