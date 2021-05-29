package fr.zenoobossdev.epiniumod.objects.data.jobs.miner;


import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class JobMinerWrapper implements ICapabilitySerializable<NBTBase>
{

    @CapabilityInject(IJobMiner.class)
    public static final Capability<IJobMiner> JOB_MINER_CAPABILITY = null;

    private IJobMiner holder = JOB_MINER_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == JOB_MINER_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing) {
        return this.hasCapability(capability, facing) ? JOB_MINER_CAPABILITY.cast(this.holder) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return JOB_MINER_CAPABILITY.getStorage().writeNBT(JOB_MINER_CAPABILITY, this.holder, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        JOB_MINER_CAPABILITY.getStorage().readNBT(JOB_MINER_CAPABILITY, this.holder, null, nbt);
    }

}
