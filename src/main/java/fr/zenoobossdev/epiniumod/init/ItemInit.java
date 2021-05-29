package fr.zenoobossdev.epiniumod.init;

import fr.zenoobossdev.epiniumod.objects.armour.ArmourBase;
import fr.zenoobossdev.epiniumod.objects.armour.MithrilArmor;
import fr.zenoobossdev.epiniumod.objects.armour.VolcaniumArmor;
import fr.zenoobossdev.epiniumod.objects.items.ItemBase;
import fr.zenoobossdev.epiniumod.objects.items.UnclaimFinder;
import fr.zenoobossdev.epiniumod.objects.tools.*;
import fr.zenoobossdev.epiniumod.util.Reference;
import fr.zenoobossdev.epiniumod.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit
{
    public static List<Item> ITEMS = new ArrayList<Item>();

    //Materials
    public static final Item VOLCANIUM_ORB = new ItemBase("volcanium_orb");
    public static final Item MITHRIL_STICK = new ItemBase("mithril_stick");
    public static final Item MITHRIL_INGOT = new ItemBase("mithril_ingot");
    public static final Item.ToolMaterial TOOL_MITHRIL = EnumHelper.addToolMaterial("tool_mithril", 4, 2200, 12.0F, 7.0F, 14 ).setRepairItem(new ItemStack(ItemInit.MITHRIL_INGOT));
    public static final ItemArmor.ArmorMaterial ARMOUR_MITHRIL = EnumHelper.addArmorMaterial("armour_mithril", Reference.MODID + ":mithril", 39, new int[]{4, 9, 7, 4}, 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.5F);
    public static final Item.ToolMaterial TOOL_VOLCANIUM = EnumHelper.addToolMaterial("tool_volcanium", 5, 4000, 16.0F, 11.0F, 16 ).setRepairItem(new ItemStack(ItemInit.VOLCANIUM_ORB));
    public static final ItemArmor.ArmorMaterial ARMOUR_VOLCANIUM = EnumHelper.addArmorMaterial("armour_volcanium", Reference.MODID + ":volcanium", 39, new int[]{5, 11, 9, 5}, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4F);


    //Tools
    //Mithril
    public static final Item MITHRIL_AXE = new ToolAxe("mithril_axe", TOOL_MITHRIL);
    public static final Item MITHRIL_HOE = new ToolHoe("mithril_hoe", TOOL_MITHRIL);
    public static final Item MITHRIL_PICKAXE = new ToolPickaxe("mithril_pickaxe", TOOL_MITHRIL, 4);
    public static final Item MITHRIL_SHOVEL = new ToolShovel("mithril_shovel", TOOL_MITHRIL);
    public static final Item MITHRIL_SWORD = new ToolSword("mithril_sword", TOOL_MITHRIL);

    //Volcanium
    public static final Item VOLCANIUM_PICKAXE = new ToolPickaxe("volcanium_pickaxe", TOOL_VOLCANIUM, 5);
    public static final Item VOLCANIUM_SWORD = new ToolSword("volcanium_sword", TOOL_VOLCANIUM);
    public static final Item VOLCANIUM_HAMMER = new VolcaniumHammer("volcanium_hammer", TOOL_VOLCANIUM, 5);

    //Armours

    //Mithril
    public static final Item MITHRIL_HELMET = new MithrilArmor("mithril_helmet", ARMOUR_MITHRIL, 1, EntityEquipmentSlot.HEAD);
    public static final Item MITHRIL_CHESTPLATE = new MithrilArmor("mithril_chestplate", ARMOUR_MITHRIL, 1, EntityEquipmentSlot.CHEST);
    public static final Item MITHRIL_LEGGINGS = new MithrilArmor("mithril_leggings", ARMOUR_MITHRIL, 2, EntityEquipmentSlot.LEGS);
    public static final Item MITHRIL_BOOTS = new MithrilArmor("mithril_boots", ARMOUR_MITHRIL, 1, EntityEquipmentSlot.FEET);

    //Volcanium
    public static final Item VOLCANIUM_HELMET = new VolcaniumArmor("volcanium_helmet", ARMOUR_VOLCANIUM, 1, EntityEquipmentSlot.HEAD);
    public static final Item VOLCANIUM_CHESTPLATE = new VolcaniumArmor("volcanium_chestplate", ARMOUR_VOLCANIUM, 1, EntityEquipmentSlot.CHEST);
    public static final Item VOLCANIUM_LEGGINGS = new VolcaniumArmor("volcanium_leggings", ARMOUR_VOLCANIUM, 2, EntityEquipmentSlot.LEGS);
    public static final Item VOLCANIUM_BOOTS = new VolcaniumArmor("volcanium_boots", ARMOUR_VOLCANIUM, 1, EntityEquipmentSlot.FEET);


    //Miscellaneous
    public static final Item MONEY = new ItemBase("money");
    public static final Item UNCLAIM_FINDER = new UnclaimFinder("unclaim_finder");
}
