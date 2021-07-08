package fr.zenoobossdev.epiniumod.packets;

import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class XpMessage implements IMessage {
    public XpMessage() {
    }

    private String player;
    private static String xp;

    public XpMessage(String player) {
        this.player = player;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        xp = ByteBufUtils.readUTF8String(buf);
    }

    public String getPlayer() {
        return this.player;
    }
    public static String getXp(){
        return xp;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, player);
    }


    public static class XpMessageHandler implements IMessageHandler<XpMessage, IMessage> {
        @Override
        public IMessage onMessage(XpMessage message, MessageContext ctx) {
            System.out.println(String.format("Received %s from %s", message.getPlayer(), ctx.getServerHandler().player.getDisplayName()));
            EntityPlayer player = Minecraft.getMinecraft().world.getPlayerEntityByName(message.getPlayer());
            int xp = player.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null).getXp();
            return new XpMessage(String.valueOf(xp));
        }
    }
}
