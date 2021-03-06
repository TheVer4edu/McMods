package com.example.examplemod.registries;

import com.example.examplemod.items.KeyItem;
import com.example.examplemod.items.SomeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder("postniymod")
@Mod.EventBusSubscriber
public class ItemsRegistry {

    @GameRegistry.ObjectHolder("key")
    public static final Item KEY = null;  // мб имеет смысл хранить все айтемы коллекцией?
    @GameRegistry.ObjectHolder("some_item")
    public static final Item SOME = null; // или от этого теряется смысл самой концепции?
    //private static Item some = new SomeItem(3, 1, false);

    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(
                new KeyItem()
        //        new SomeItem(3, 1, false)
        );
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        //registryModel(KEY);
        //registryModel(SOME);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModel(Item item) {
        final ResourceLocation regName = item.getRegistryName();
        final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
        ModelBakery.registerItemVariants(item, mrl);
        ModelLoader.setCustomModelResourceLocation(item, 0, mrl);
    }

    // альтернативный способ регистрации модели через какие-то другие костыли, можно будет перенести на SubscribeEvent

    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        setRender(KEY);
        setRender(SOME);
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher() // не ебу, что это
                .register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void register() {
        //ForgeRegistries.ITEMS.registerAll(some);
    }

}
