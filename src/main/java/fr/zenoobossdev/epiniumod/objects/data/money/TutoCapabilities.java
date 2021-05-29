package fr.zenoobossdev.epiniumod.objects.data.money;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.concurrent.Callable;

public class TutoCapabilities implements ICapabilityProvider, INBTSerializable<NBTTagCompound> {
    @Override
    public boolean hasCapability(Capability capability, EnumFacing facing)
    {
        return JobMinerWrapper.JOB_MINER_CAPABILITY != null && capability == JobMinerWrapper.JOB_MINER_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability <T>capability, EnumFacing facing)
    {
        return JobMinerWrapper.JOB_MINER_CAPABILITY != null && capability == JobMinerWrapper.JOB_MINER_CAPABILITY ? (T)this : null;
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger("Xp", this.getXp());
        return compound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound compound)
    {
        this.setXp(compound.getInteger("Xp"));
    }

    public int xp;

    public void setXp(int xp)
    {
        this.xp = xp;
    }

    public int getXp()
    {
        return this.xp;
    }

    public static class Storage implements Capability.IStorage<TutoCapabilities> {

        @Override
        public NBTBase writeNBT(Capability<TutoCapabilities> capability, TutoCapabilities instance, EnumFacing side)
        {
            return null;
        }

        @Override
        public void readNBT(Capability<TutoCapabilities> capability, TutoCapabilities instance, EnumFacing side, NBTBase nbt)
        {

        }

    }

    public static class Factory implements Callable<TutoCapabilities> {
        @Override
        public TutoCapabilities call() throws Exception
        {
            return null;
        }
    }

    private EntityPlayer player;

    public static void register()
    {
        CapabilityManager.INSTANCE.register(TutoCapabilities.class, new TutoCapabilities.Storage(), new TutoCapabilities.Factory());
    }

    public TutoCapabilities(EntityPlayer player)
    {
        this.xp = 0;
        this.player = player;
    }

    public void sync()
    {
        PacketCapabilitiesTutoriel packet = new PacketCapabilitiesTutoriel(this.getXp());
        if(!this.player.world.isRemote)
        {
            EntityPlayerMP playerMP = (EntityPlayerMP)player;
            Main.network.sendTo(packet, playerMP);
        }
        else
        {
            Main.network.sendToServer(packet);
        }
    }
}