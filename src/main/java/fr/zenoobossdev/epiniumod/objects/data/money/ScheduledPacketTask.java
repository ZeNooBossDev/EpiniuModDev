package fr.zenoobossdev.epiniumod.objects.data.money;

import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ScheduledPacketTask implements Runnable
{
    private EntityPlayer player;
    private PacketCapabilitiesTutoriel message;

    public ScheduledPacketTask(EntityPlayer player, PacketCapabilitiesTutoriel message)
    {
        this.player = player;
        this.message = message;
    }

    @Override
    public void run()
    {
        //Condition ternaire pour récupérer le joueur selon le côté.
        EntityPlayer player = this.player == null ? getPlayer() : this.player;
        //On revient sur cette ligne plus tard.
        player.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null).setXp(message.xp);
    }

    @SideOnly(Side.CLIENT)
    private EntityPlayer getPlayer()
    {
        return Minecraft.getMinecraft().player;
    }

}