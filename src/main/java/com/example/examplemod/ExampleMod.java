package com.example.examplemod;

import com.example.examplemod.registries.BlockRegistry;
import com.example.examplemod.registries.ItemsRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)

public class ExampleMod
{
    public static final String MODID = "postniymod";
    public static final String NAME = "Postniy Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // Преинициализация
        System.out.println("\u001B[32m" + "[Starting Test Mod PRE-INITIALIZATION]" + "\u001B[0m");
        BlockRegistry.register();
        //ItemsRegistry.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Инициализация
        System.out.println("\u001B[32m" + "[Starting Test Mod INITIALIZATION]" + "\u001B[0m");
        ItemsRegistry.registerRender();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // Инициализация
        System.out.println("\u001B[32m" + "[Starting Test Mod POST-INITIALIZATION]" + "\u001B[0m");
    }
}
