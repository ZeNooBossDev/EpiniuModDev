package fr.zenoobossdev.epiniumod.init;


import fr.zenoobossdev.epiniumod.objects.blocks.BlockBasic;
import fr.zenoobossdev.epiniumod.objects.blocks.CaveBlock;
import fr.zenoobossdev.epiniumod.objects.blocks.MithrilBlock;
import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.BlockDiamondFurnace;
import fr.zenoobossdev.epiniumod.objects.blocks.VolcaniumOreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static List<Block> BLOCKS = new ArrayList<Block>();


    public static final Block MITHRIL_ORE_BLOCK = new BlockBasic("mithril_ore_block", Material.ROCK);
    public static final Block MITHRIL_BLOCK = new MithrilBlock("mithril_block", Material.IRON, 3);
    public static final Block DIAMOND_FURNACE = new BlockDiamondFurnace("diamond_furnace");
    public static final Block VOLCANIUM_ORE_BLOCK = new VolcaniumOreBlock("volcanium_ore_block", Material.ROCK);
    public static final Block VOLCANIUM_BLOCK = new MithrilBlock("volcanium_block", Material.IRON, 4);
    public static final Block CAVE_BLOCK = new CaveBlock("cave_block", Material.IRON);

    public static final Block VOLCANIC_PLANKS = new BlockPlanks();
}
