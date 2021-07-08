package fr.zenoobossdev.epiniumod.objects.commands;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.packets.XpMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class TestPacketsCommand extends CommandBase
{

    @Override
    public String getName() {
        return "packet";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        Main.network.sendToServer(new XpMessage("ZeNooBoss"));
        System.out.println(XpMessage.getXp());
    }
}
