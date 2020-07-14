package com.example.examplemod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class SomeItem extends ItemFood {
    public SomeItem(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setRegistryName("some_item");
        setUnlocalizedName("some_item");
        setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        if (player.getFoodStats().getFoodLevel() == 20)
            player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 180));
        super.onFoodEaten(stack, world, player);
        player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 1380, 4));
        player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1380, 4));
    }
}
