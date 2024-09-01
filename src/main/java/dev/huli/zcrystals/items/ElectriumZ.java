package dev.huli.zcrystals.items;

import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import dev.huli.zcrystals.ZCrystals;
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

import java.util.Random;

public class ElectriumZ extends SimplePolymerItem {

    private static final Random rng = new Random();

    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        if(livingEntity instanceof PokemonEntity pokemonEntity && !playerEntity.isSneaking()){
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("raichu")){
                if(PokemonProperties.Companion.parse("alolan"," ","=").matches(pokemonEntity)){
                    playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.ALORAICHIUM_Z));
                    return ActionResult.SUCCESS;
                }
            }
            if(pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("pikachu")){
                if(rng.nextInt(101) < ZCrystals.config.cobbleTransformationsConfigDataManager.ASHPIKACHIUMZ_CHANCE){
                    playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.PIKASHUNIUM_Z));
                    return ActionResult.SUCCESS;
                }
                else{
                    playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.PIKANIUM_Z));
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
        this.modelData = ZCrystalItems.electriumZModelData;
        return this.modelData.value();
    }
}
