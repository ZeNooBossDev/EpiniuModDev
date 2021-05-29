package fr.zenoobossdev.epiniumod;


import fr.zenoobossdev.epiniumod.objects.commands.JobCommand;
import fr.zenoobossdev.epiniumod.objects.commands.LevelCommand;
import fr.zenoobossdev.epiniumod.objects.commands.XpCommand;
import fr.zenoobossdev.epiniumod.objects.data.money.EventHandler;
import fr.zenoobossdev.epiniumod.objects.data.money.PacketCapabilitiesTutoriel;
import fr.zenoobossdev.epiniumod.objects.data.money.TutoCapabilities;
import fr.zenoobossdev.epiniumod.util.handlers.RenderGuiHandler;
import fr.zenoobossdev.epiniumod.tabs.EpiniumTab;
import fr.zenoobossdev.epiniumod.util.Reference;
import fr.zenoobossdev.epiniumod.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{

    @CapabilityInject(TutoCapabilities.class)
    public static final Capability<TutoCapabilities> TUTO_CAP = null;


    public static SimpleNetworkWrapper network;
    public static final CreativeTabs epiniumtab = new EpiniumTab("epiniumtab");

    @Mod.Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static  fr.zenoobossdev.epiniumod.proxy.CommonProxy proxy;

    public static org.apache.logging.log4j.Logger logger;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e)
    {
        logger = e.getModLog();

        proxy.preInit();
        proxy.registerGuis();

        network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
        network.registerMessage(PacketCapabilitiesTutoriel.ServerHandler.class, PacketCapabilitiesTutoriel.class, 3, Side.SERVER);


        RegistryHandler.preInitRegistries();


    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent e)
    {
        RegistryHandler.initRegistries();
        TutoCapabilities.register();
        PermissionAPI.registerNode("modid.command.xp", DefaultPermissionLevel.OP, "Allows players to use the xp command");
        PermissionAPI.registerNode("modid.command.level", DefaultPermissionLevel.OP, "Allows players to use the job command");
        PermissionAPI.registerNode("modid.command.job", DefaultPermissionLevel.ALL, "Allows players to use the job command");

    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e)
    {
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());

    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new XpCommand());
        event.registerServerCommand(new JobCommand());
        event.registerServerCommand(new LevelCommand());
    }

}
