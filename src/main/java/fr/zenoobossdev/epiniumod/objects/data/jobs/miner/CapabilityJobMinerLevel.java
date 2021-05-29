package fr.zenoobossdev.epiniumod.objects.data.jobs.miner;

import fr.zenoobossdev.epiniumod.util.Reference;
import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Map;
import java.util.WeakHashMap;

public class CapabilityJobMinerLevel {

    public static final ResourceLocation CAP_KEY = new ResourceLocation(Reference.MODID, "jobminerlevel");


    private static final Map<Entity, IJobMiner> INVALIDATED_CAPS = new WeakHashMap<>();


    @SubscribeEvent
    public static void attachToEntities(AttachCapabilitiesEvent<Entity> event)
    {

        JobMinerWrapper wrapper=new JobMinerWrapper();
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(CAP_KEY, new JobMinerWrapper());

        }
    }
}
