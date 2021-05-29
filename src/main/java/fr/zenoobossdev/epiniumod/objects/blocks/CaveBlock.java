package fr.zenoobossdev.epiniumod.objects.blocks;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.init.BlockInit;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import fr.zenoobossdev.epiniumod.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CaveBlock extends Block implements IHasModel
{
    public CaveBlock(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.epiniumtab);
        setHardness(2.0F);
        setHarvestLevel("pickaxe", 3);
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k(){
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
}
