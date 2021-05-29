package fr.zenoobossdev.epiniumod.util.handlers;


import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.ContainerDiamondFurnace;
import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.GuiDiamondFurnace;
import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.TileEntityDiamondFurnace;
import fr.zenoobossdev.epiniumod.guis.JobsGUI;
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
        if (ID == Reference.GUI_DIAMOND_FURNACE) return new ContainerDiamondFurnace(player.inventory, (TileEntityDiamondFurnace) world.getTileEntity(new BlockPos(x,y,z)), player);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == Reference.GUI_DIAMOND_FURNACE) return new GuiDiamondFurnace(player.inventory, (TileEntityDiamondFurnace) world.getTileEntity(new BlockPos(x,y,z)), player);
        return null;
    }
}
