package fr.zenoobossdev.epiniumod.proxy;

import fr.zenoobossdev.epiniumod.guis.GuiUnclaimFinder;
import fr.zenoobossdev.epiniumod.guis.JobsGUI;
import fr.zenoobossdev.epiniumod.guis.MinerGui;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;


@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @Override
    public void registerItemRenderer(Item item, int meta)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        MinecraftForge.EVENT_BUS.register(new GuiUnclaimFinder());
        MinecraftForge.EVENT_BUS.register(new JobsGUI());
        MinecraftForge.EVENT_BUS.register(new MinerGui());


    }

    @Override
    public void registerVariantRenderer(Item item, int meta, String filename, String id) {
        super.registerVariantRenderer(item, meta, filename, id);
    }

    @Override
    public void preInit() {
        super.preInit();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    }

    @Override
    public void registerGuis() {
    }
}
