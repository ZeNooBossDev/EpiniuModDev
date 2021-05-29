package fr.zenoobossdev.epiniumod.proxy;

import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.CapabilityJobMiner;
import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.DefaultJobMinerStorage;
import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.Factory;
import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy
{
    public void registerItemRenderer(Item item, int meta)
    {

    }

    public void registerVariantRenderer(Item item, int meta, String filename, String id)
    {

    }


    public void registerGuis()
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
        CapabilityManager.INSTANCE.register(IJobMiner.class, new DefaultJobMinerStorage(),new Factory());
        MinecraftForge.EVENT_BUS.register(CapabilityJobMiner.class);
    }

}
