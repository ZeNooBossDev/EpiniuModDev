package fr.zenoobossdev.epiniumod.init;


import fr.zenoobossdev.epiniumod.objects.blocks.BasicMetallicInfuser;
import fr.zenoobossdev.epiniumod.objects.blocks.BlockBasic;
import fr.zenoobossdev.epiniumod.objects.blocks.MithrilBlock;
import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.BlockSinteringFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block MITHRIL_ORE_BLOCK = new BlockBasic("mithril_ore_block", Material.ROCK);
    public static final Block MITHRIL_BLOCK = new MithrilBlock("mithril_block", Material.IRON);
    public static final Block DIAMOND_FURNACE = new BlockSinteringFurnace("diamond_furnace");
    public static final Block BASIC_METALLIC_INFUSER = new BasicMetallicInfuser( Material.IRON, "basic_metallic_infuser");


}
