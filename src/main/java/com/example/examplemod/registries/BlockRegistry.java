package com.example.examplemod.registries;

import com.example.examplemod.blocks.AlphaBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRegistry {

    public static Block ALPHA_BLOCK = new AlphaBlock("alpha_block");

    public static void register() {
        setRegister(ALPHA_BLOCK);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        setRender(ALPHA_BLOCK);
    }

    private static void setRegister(Block block) {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Block block) {

    }
}
