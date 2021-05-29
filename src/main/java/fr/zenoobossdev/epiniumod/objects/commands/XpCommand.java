package fr.zenoobossdev.epiniumod.objects.commands;

import com.google.common.collect.Lists;
import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.server.permission.PermissionAPI;

import java.util.List;

public class XpCommand extends CommandBase
{

    @Override
    public String getName() {
        return "xp";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (sender instanceof EntityPlayer)
            return PermissionAPI.hasPermission((EntityPlayer) sender, "modid.command.xp");
        return true;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "xpcommand.help";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if (args.length < 4) throw new WrongUsageException(this.getUsage(sender));


            int count=0;
            if (args.length>0) try {
                count = parseInt(args[3]);

            }catch (NumberFormatException ex){}





            String job;
            String action;
            String name;

            job = args[0];
            if (!job.equals("miner"))throw new WrongUsageException(this.getUsage(sender));
            action = args[1];
            if (action.equals("add")||action.equals("reduce")||action.equals("set")){}
            else throw new WrongUsageException(this.getUsage(sender));
            name = args[2];
            if (name.equals("null")) {
                throw new NumberInvalidException(this.getUsage(sender));
            }

            EntityPlayer target = sender.getEntityWorld().getPlayerEntityByName(name);
            if (target==null) {
                throw new PlayerNotFoundException(this.getUsage(sender));
            }

            if (job.equals("miner")){
                IJobMiner capability = target.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);
                if (action.equals("add"))capability.increaseXp(count);
                if (action.equals("reduce"))capability.reduceXp(count);
                if (action.equals("set"))capability.setXp(count);
            }


    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos target){
       switch (args.length) {
           case 1:
               return Lists.newArrayList("miner");
           case 2:
               return Lists.newArrayList("add", "reduce", "set");
           case 3:
               return Lists.newArrayList(server.getOnlinePlayerNames()[0]);
       }
       return Lists.newArrayList();
   }


}


