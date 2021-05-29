package fr.zenoobossdev.epiniumod.objects.items;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import fr.zenoobossdev.epiniumod.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class Money extends Item implements IHasModel
{
    public Money(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.epiniumtab);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0);
    }


}
