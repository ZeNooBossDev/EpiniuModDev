package fr.zenoobossdev.epiniumod.init;

import fr.zenoobossdev.epiniumod.objects.armour.ArmourBase;
import fr.zenoobossdev.epiniumod.objects.items.ItemBase;
import fr.zenoobossdev.epiniumod.objects.tools.*;
import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit
{
    public static List<Item> ITEMS = new ArrayList<Item>();

    //Materials
    public static final Item MITHRIL_INGOT = new ItemBase("mithril_ingot");
    public static final Item.ToolMaterial TOOL_MITHRIL = EnumHelper.addToolMaterial("tool_mithril", 4, 2000, 12.0F, 3.0F, 14 );
    public static final ItemArmor.ArmorMaterial ARMOUR_MITHRIL = EnumHelper.addArmorMaterial("armour_mithril", Reference.MODID + ":mithril", 39, new int[]{4, 7, 9, 4}, 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.5F);

    //Tools
    public static final Item MITHRIL_AXE = new ToolAxe("mithril_axe", TOOL_MITHRIL);
    public static final Item MITHRIL_HOE = new ToolHoe("mithril_hoe", TOOL_MITHRIL);
    public static final Item MITHRIL_PICKAXE = new ToolPickaxe("mithril_pickaxe", TOOL_MITHRIL);
    public static final Item MITHRIL_SHOVEL = new ToolShovel("mithril_shovel", TOOL_MITHRIL);
    public static final Item MITHRIL_SWORD = new ToolSword("mithril_sword", TOOL_MITHRIL);

    //Armours
    public static final Item MITHRIL_HELMET = new ArmourBase("mithril_helmet", ARMOUR_MITHRIL, 1, EntityEquipmentSlot.HEAD);
    public static final Item MITHRIL_CHESTPLATE = new ArmourBase("mithril_chestplate", ARMOUR_MITHRIL, 1, EntityEquipmentSlot.CHEST);
    public static final Item MITHRIL_LEGGINGS = new ArmourBase("mithril_leggings", ARMOUR_MITHRIL, 2, EntityEquipmentSlot.LEGS);
    public static final Item MITHRIL_BOOTS = new ArmourBase("mithril_boots", ARMOUR_MITHRIL, 1, EntityEquipmentSlot.FEET);
}
