package fr.zenoobossdev.epiniumod.init;

import fr.zenoobossdev.epiniumod.objects.armour.ArmourBase;
import fr.zenoobossdev.epiniumod.objects.items.ItemBase;
import fr.zenoobossdev.epiniumod.objects.tools.ToolHoe;
import fr.zenoobossdev.epiniumod.objects.tools.ToolPickaxe;
import fr.zenoobossdev.epiniumod.objects.tools.ToolShovel;
import fr.zenoobossdev.epiniumod.objects.tools.ToolSword;
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
    public static final ItemArmor.ArmorMaterial _MITHRIL = EnumHelper.addToolMaterial("tool_mithril", 4, 2000, 12.0F, 3.0F, 14 );

    //Tools
    public static final Item MITHRIL_AXE = new ToolAxe("mithril_axe");
    public static final Item MITHRIL_HOE = new ToolHoe("mithril_hoe");
    public static final Item MITHRIL_PICKAXE = new ToolPickaxe("mithril_pickaxe");
    public static final Item MITHRIL_SHOVEL = new ToolShovel("mithril_shovel");
    public static final Item MITHRIL_SWORD = new ToolSword("mithril_sword");

    //Armours
    public static final Item MITHRIL_HELMET = new ArmourBase("mithril_helmet");
    public static final Item MITHRIL_CHESTPLATE = new ArmourBase("mithril_chestplate");
    public static final Item MITHRIL_LEGGINGS = new ArmourBase("mithril_leggings");
    public static final Item MITHRIL_BOOTS = new ArmourBase("mithril_boots");
}
