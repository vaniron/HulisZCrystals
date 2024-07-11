package dev.huli.zcrystals.items.clientside;

import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import dev.huli.zcrystals.util.ZCrystalsClientSide;
import dev.huli.zcrystals.util.ZCrystalsClientSide;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class ElectriumZ extends Item {
    
    public ElectriumZ(Settings settings){
        super(settings);
    }


    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        if(livingEntity instanceof PokemonEntity pokemonEntity){
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("raichu")){
                if(PokemonProperties.Companion.parse("alolan"," ","=").matches(pokemonEntity)){
                    itemStack.decrement(1);
                    playerEntity.giveItemStack(new ItemStack(ZCrystalsClientSide.ALORAICHIUM_Z));
                    return ActionResult.SUCCESS;
                }
            }
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("pikachu")){
                if(PokemonProperties.Companion.parse("pikachu_hat=original"," ","=").matches(pokemonEntity)
                        || PokemonProperties.Companion.parse("pikachu_hat=hoenn"," ","=").matches(pokemonEntity)
                        || PokemonProperties.Companion.parse("pikachu_hat=sinnoh"," ","=").matches(pokemonEntity)
                        || PokemonProperties.Companion.parse("pikachu_hat=unova"," ","=").matches(pokemonEntity)
                        || PokemonProperties.Companion.parse("pikachu_hat=kalos"," ","=").matches(pokemonEntity)
                        || PokemonProperties.Companion.parse("pikachu_hat=alola"," ","=").matches(pokemonEntity)
                        || PokemonProperties.Companion.parse("pikachu_hat=partner"," ","=").matches(pokemonEntity)
                ){
                    itemStack.decrement(1);
                    playerEntity.giveItemStack(new ItemStack(ZCrystalsClientSide.PIKASHUNIUM_Z));
                    return ActionResult.SUCCESS;
                }

                itemStack.decrement(1);
                playerEntity.giveItemStack(new ItemStack(ZCrystalsClientSide.PIKANIUM_Z));
                return ActionResult.SUCCESS;
            }

        }
        return ActionResult.PASS;
    }

}
