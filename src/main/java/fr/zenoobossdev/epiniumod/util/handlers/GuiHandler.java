package fr.zenoobossdev.epiniumod.util.handlers;


import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.ContainerSinteringFurnace;
import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.GuiSinteringFurnace;
import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.TileEntitySinteringFurnace;
import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;


public class GuiHandler implements IGuiHandler
{

    public static final int PEDESTAL = 0;


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == Reference.GUI_DIAMOND_FURNACE) return new ContainerSinteringFurnace(player.inventory, (TileEntitySinteringFurnace) world.getTileEntity(new BlockPos(x,y,z)), player);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == Reference.GUI_DIAMOND_FURNACE) return new GuiSinteringFurnace(player.inventory, (TileEntitySinteringFurnace) world.getTileEntity(new BlockPos(x,y,z)), player);
        return null;
    }
}
