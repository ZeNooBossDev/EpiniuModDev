package fr.zenoobossdev.epiniumod.objects.tools;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import fr.zenoobossdev.epiniumod.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel
{
    public ToolPickaxe(String name, ToolMaterial material, int harvestLevel)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.epiniumtab);
        ItemInit.ITEMS.add(this);
        setHarvestLevel("pickaxe", harvestLevel);

    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
