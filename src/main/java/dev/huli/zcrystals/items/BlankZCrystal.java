package dev.huli.zcrystals.items;

import dev.huli.zcrystals.util.ZCrystalItems;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.Difficulty;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class BlankZCrystal extends SimplePolymerItem {
    PolymerModelData modelData;
    public BlankZCrystal(Settings settings, Item polymerItem){
        super(settings,polymerItem);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext) {
        Block block = itemUsageContext.getWorld().getBlockState(itemUsageContext.getBlockPos()).getBlock();
        PlayerEntity player = Objects.requireNonNull(itemUsageContext.getPlayer());

        if(block == Blocks.WHEAT){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.GRASSIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.MAGMA_BLOCK){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.FIRIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.BEEHIVE){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.BUGINIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.POWDER_SNOW){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.ICIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.REINFORCED_DEEPSLATE){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.DARKINIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.BEDROCK){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.ROCKIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.DRAGON_HEAD || block == Blocks.DRAGON_WALL_HEAD){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.DRAGONIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.COPPER_BLOCK){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.ELECTRIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.MUD){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.GROUNDIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(player.getWorld().getDifficulty() == Difficulty.PEACEFUL && block == Blocks.POTATOES){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.POISONIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.SOUL_SAND){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.GHOSTIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.BAMBOO_BLOCK){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.FIGHTINIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.WET_SPONGE){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.WATERIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.END_GATEWAY){
            player.setStackInHand(itemUsageContext.getHand(), new ItemStack(ZCrystalItems.PSYCHIUM_Z));
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {

        if(livingEntity instanceof ChickenEntity){
            livingEntity.kill();
            playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.FLYINIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(livingEntity instanceof VexEntity){
            livingEntity.kill();
            playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.FAIRIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(livingEntity instanceof IronGolemEntity){
            livingEntity.kill();
            playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.STEELIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(playerEntity.getEntityWorld().getDifficulty() != Difficulty.PEACEFUL && livingEntity instanceof CaveSpiderEntity){
            livingEntity.kill();
            playerEntity.setStackInHand(hand, new ItemStack(ZCrystalItems.POISONIUM_Z));
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }


    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        return super.getPolymerItem(itemStack,player);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        this.modelData = ZCrystalItems.blankZCrystalModelData;
        return this.modelData.value();
    }
}
