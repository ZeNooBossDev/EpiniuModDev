package fr.zenoobossdev.epiniumod.proxy;

import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public void registerItemRenderer(Item item, int meta)
    {

    }

    public void registerVariantRenderer(Item item, int meta, String filename, String id)
    {

    }


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {



    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

    public void registerEntityRenderers()
    {

    }
    public void preInit()
    {

    }

}
