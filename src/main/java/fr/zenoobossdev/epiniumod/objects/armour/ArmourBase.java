package fr.zenoobossdev.epiniumod.objects.armour;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import fr.zenoobossdev.epiniumod.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ArmourBase extends ItemArmor implements IHasModel
{
       public ArmourBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
       {
           super(materialIn, renderIndexIn, equipmentSlotIn);
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
