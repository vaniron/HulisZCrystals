package dev.huli.zcrystals.items.clientside;

import dev.huli.zcrystals.util.ZCrystalsClientSide;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import java.util.Objects;

public class BlankZCrystal extends Item {
    public BlankZCrystal(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext) {
        Block block = itemUsageContext.getWorld().getBlockState(itemUsageContext.getBlockPos()).getBlock();
        PlayerEntity player = Objects.requireNonNull(itemUsageContext.getPlayer());
        ItemStack heldStack = Objects.requireNonNull(itemUsageContext.getPlayer()).getMainHandStack();

        if(block == Blocks.WHEAT){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.GRASSIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.MAGMA_BLOCK){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.FIRIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.VINE){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.BUGINIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.POWDER_SNOW){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.ICIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.REINFORCED_DEEPSLATE){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.DARKINIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.BEDROCK){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.ROCKIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.END_PORTAL_FRAME){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.DRAGONIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.COPPER_BLOCK){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.ELECTRIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.MUD){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.GROUNDIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(player.getWorld().getDifficulty() == Difficulty.PEACEFUL && block == Blocks.POTATOES){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.POISONIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.SOUL_SAND){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.GHOSTIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.BAMBOO_BLOCK){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.FIGHTINIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.WET_SPONGE){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.WATERIUM_Z));
            return ActionResult.SUCCESS;
        }
        if(block == Blocks.END_GATEWAY){
            heldStack.decrement(1);
            player.giveItemStack(new ItemStack(ZCrystalsClientSide.PSYCHIUM_Z));
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {

        if(livingEntity instanceof ChickenEntity){
            itemStack.decrement(1);
            livingEntity.kill();
            playerEntity.giveItemStack(new ItemStack(ZCrystalsClientSide.FLYINIUM_Z));
            return ActionResult.CONSUME;
        }
        if(livingEntity instanceof AllayEntity){
            itemStack.decrement(1);
            playerEntity.giveItemStack(new ItemStack(ZCrystalsClientSide.FAIRIUM_Z));
            return ActionResult.CONSUME;
        }
        if(livingEntity instanceof IronGolemEntity){
            itemStack.decrement(1);
            livingEntity.kill();
            playerEntity.giveItemStack(new ItemStack(ZCrystalsClientSide.STEELIUM_Z));
            return ActionResult.CONSUME;
        }
        if(playerEntity.getEntityWorld().getDifficulty() != Difficulty.PEACEFUL && livingEntity instanceof CaveSpiderEntity){
            itemStack.decrement(1);
            livingEntity.kill();
            playerEntity.giveItemStack(new ItemStack(ZCrystalsClientSide.POISONIUM_Z));
            return ActionResult.CONSUME;
        }

        return ActionResult.PASS;
    }

}


// Bug - Vines
// Dark - Reinforced Deepslate
// Dragon - End Portal Frame
// Electric - Copper Block
// Fairy - Allay
// Fighting - Bamboo Block
// Fire - Magma Block
// Flying - Chicken
// Ghost - Soul Sand
// Grass - Wheat
// Ground - Mud
// Ice - Powder Snow
// Normal - Villager
// Poison - Cave Spider, Potato Plant
// Psychic - End Gateway
// Rock - Bedrock
// Steel - Iron Golem
// Water - Wet Sponge

