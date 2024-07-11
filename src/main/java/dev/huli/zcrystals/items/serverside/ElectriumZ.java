package dev.huli.zcrystals.items.serverside;

import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
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

public class ElectriumZ extends SimplePolymerItem {

    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        if(livingEntity instanceof PokemonEntity pokemonEntity){
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("raichu")){
                if(PokemonProperties.Companion.parse("alolan"," ","=").matches(pokemonEntity)){
                    itemStack.decrement(1);
                    playerEntity.giveItemStack(new ItemStack(ZCrystalsServerSide.ALORAICHIUM_Z));
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
                    playerEntity.giveItemStack(new ItemStack(ZCrystalsServerSide.PIKASHUNIUM_Z));
                    return ActionResult.SUCCESS;
                }
                else{


                itemStack.decrement(1);
                playerEntity.giveItemStack(new ItemStack(ZCrystalsServerSide.PIKANIUM_Z));
                return ActionResult.SUCCESS;
                }
            }

        }
        return ActionResult.PASS;
    }

    PolymerModelData modelData;
    public ElectriumZ(Settings settings, Item polymerItem){
        super(settings, polymerItem);
    }
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        return super.getPolymerItem(itemStack,player);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        this.modelData = ZCrystalsServerSide.electriumZModelData;
        return this.modelData.value();
    }
}
