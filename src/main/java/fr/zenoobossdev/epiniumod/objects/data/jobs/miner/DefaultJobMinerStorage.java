package fr.zenoobossdev.epiniumod.objects.data.jobs.miner;

import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.*;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import javax.swing.text.html.parser.Entity;

public class DefaultJobMinerStorage implements Capability.IStorage<IJobMiner> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IJobMiner> capability, IJobMiner instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setTag("xp", new NBTTagInt(instance.getXp()));
        tag.setTag("level", new NBTTagInt(instance.getLevel()));
        return tag;
    }

    @Override
    public void readNBT(Capability<IJobMiner> capability, IJobMiner instance, EnumFacing side, NBTBase nbt) {
       if (nbt instanceof NBTTagCompound){
           instance.setXp(((NBTTagCompound)nbt).getInteger("xp"));
           instance.setLevel(((NBTTagCompound)nbt).getInteger("level"));
       }
    }
}