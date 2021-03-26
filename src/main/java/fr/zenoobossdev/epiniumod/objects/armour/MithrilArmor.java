package fr.zenoobossdev.epiniumod.objects.armour;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import fr.zenoobossdev.epiniumod.util.interfaces.IHasModel;
import ibxm.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent;

public class MithrilArmor extends ItemArmor implements IHasModel
{
       public MithrilArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
       {
           super(materialIn, renderIndexIn, equipmentSlotIn);
           setUnlocalizedName(name);
           setRegistryName(name);
           setCreativeTab(Main.epiniumtab);


           ItemInit.ITEMS.add(this);
       }


    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem() == ItemInit.MITHRIL_INGOT)
        {
            return true;
        }
        return false;
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
    {
        if (this.armorType == EntityEquipmentSlot.HEAD)
        {
        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 20, -1));

    }


}



    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);

    }
}



