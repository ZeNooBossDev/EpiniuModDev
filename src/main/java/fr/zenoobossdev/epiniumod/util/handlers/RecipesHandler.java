package fr.zenoobossdev.epiniumod.util.handlers;

import fr.zenoobossdev.epiniumod.init.BlockInit;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import net.minecraft.item.ItemSaddle;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesHandler
{
    public static void registerRecipes()
    {
        GameRegistry.addSmelting(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK), new ItemStack(ItemInit.MITHRIL_INGOT, 1), 5.0f);

    }
}
