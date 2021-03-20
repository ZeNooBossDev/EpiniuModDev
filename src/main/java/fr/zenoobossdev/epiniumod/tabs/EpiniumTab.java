package fr.zenoobossdev.epiniumod.tabs;

import fr.zenoobossdev.epiniumod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EpiniumTab extends CreativeTabs
{
    public EpiniumTab(String label)
    {
        super("epiniumtab");
        this.setBackgroundImageName("epinium.png");
    }
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.MITHRIL_INGOT);
    }
}
