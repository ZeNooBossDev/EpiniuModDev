package fr.zenoobossdev.epiniumod;


import fr.zenoobossdev.epiniumod.proxy.CommonProxy;
import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{
    @Mod.Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    public static org.apache.logging.log4j.Logger logger;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e)
    {
        logger = e.getModLog();

        proxy.preInit();

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent e)
    {

    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e)
    {

    }
}
