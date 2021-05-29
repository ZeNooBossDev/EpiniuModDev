package fr.zenoobossdev.epiniumod.objects.armour;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import fr.zenoobossdev.epiniumod.util.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class VolcaniumArmor extends ItemArmor implements IHasModel
{
    public VolcaniumArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
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
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 40, -1));

        }
        if (this.armorType==EntityEquipmentSlot.CHEST) player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 40, 1));
        if (this.armorType==EntityEquipmentSlot.FEET) player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 40, 1));



    }



    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);

    }
}
