package fr.zenoobossdev.epiniumod.objects.commands;

import com.google.common.collect.Lists;
import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.guis.JobsGUI;
import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentScore;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

import java.util.List;

public class JobCommand extends CommandBase
{
    @Override
    public String getName() {
        return "job";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (sender instanceof EntityPlayer)
            return PermissionAPI.hasPermission((EntityPlayer) sender, "modid.command.job");
        return true;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/job <job>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length<1)throw new WrongUsageException(this.getUsage(sender));

        if (sender instanceof EntityPlayer){
            if (args[0].equals("miner")){
                /*int xpToLevelUp = ((EntityPlayer) sender).getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null).getXpLevelUp()-((EntityPlayer) sender).getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null).getXp();
                sender.sendMessage(new TextComponentString("Vous avez : "+((EntityPlayer) sender).getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null).getXp()+"xp !"));
                sender.sendMessage(new TextComponentString("Vous êtes au level : "+((EntityPlayer) sender).getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null).getLevel()));
                sender.sendMessage(new TextComponentString("Il vous reste : "+ xpToLevelUp + "xp pour level up !"));
                sender.sendMessage(new TextComponentString("Vous pouvez xp avec : "+((EntityPlayer) sender).getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null).howToXp()));*/
                Minecraft.getMinecraft().displayGuiScreen(new JobsGUI());
            }
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos target){
        switch (args.length) {
            case 1:
                return Lists.newArrayList("miner");

        }
        return Lists.newArrayList();
    }
}
