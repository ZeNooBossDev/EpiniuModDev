package fr.zenoobossdev.epiniumod.util.handlers;

import fr.zenoobossdev.epiniumod.objects.blocks.TileEntityBasicMetallicInfuser;
import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.TileEntitySinteringFurnace;
import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntitySinteringFurnace.class, new ResourceLocation(Reference.MODID + ":tile_entity_diamond_furnace"));
    }
}
