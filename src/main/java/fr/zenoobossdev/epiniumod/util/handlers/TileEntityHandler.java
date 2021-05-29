package fr.zenoobossdev.epiniumod.util.handlers;

import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.TileEntityDiamondFurnace;
import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityDiamondFurnace.class, new ResourceLocation(Reference.MODID + ":diamond_furnace"));

    }
}
