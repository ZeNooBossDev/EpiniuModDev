package fr.zenoobossdev.epiniumod.objects.data.money;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerEula;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PacketCapabilitiesTutoriel implements IMessage
{

    public int xp;

    public PacketCapabilitiesTutoriel(int xp)
    {
        this.xp = xp;
    }

    public PacketCapabilitiesTutoriel() {}

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.xp = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.xp);
    }


    public static class ServerHandler implements IMessageHandler<PacketCapabilitiesTutoriel, IMessage> {

        @Override
        public IMessage onMessage(PacketCapabilitiesTutoriel message, MessageContext ctx)
        {
            Minecraft.getMinecraft().addScheduledTask(new ScheduledPacketTask(ctx.getServerHandler().player, message));
            return null;
        }

    }

    @SideOnly(Side.CLIENT)
    public static class ClientHandler implements IMessageHandler <PacketCapabilitiesTutoriel, IMessage>{

        @Override
        public IMessage onMessage(PacketCapabilitiesTutoriel message, MessageContext ctx)
        {
            Minecraft.getMinecraft().addScheduledTask(new ScheduledPacketTask(null, message));
            return null;
        }
    }
}