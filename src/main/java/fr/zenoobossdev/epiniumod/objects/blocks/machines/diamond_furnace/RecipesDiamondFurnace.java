package fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import fr.zenoobossdev.epiniumod.init.BlockInit;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipesDiamondFurnace
{
    private static final RecipesDiamondFurnace INSTANCE = new RecipesDiamondFurnace();
  public HashMap<ItemStack, ItemStack> recipeElements = new HashMap<ItemStack, ItemStack>();
  public HashMap<ItemStack, Float> resultxp = new HashMap<ItemStack, Float>();
    private Map<ItemStack, ItemStack> recipes = new HashMap<ItemStack, ItemStack>();




    public static RecipesDiamondFurnace getInstance()
    {
        return INSTANCE;
    }


    public void addRecipe(ItemStack input, ItemStack result, float xp)
    {
        recipeElements.put(input, result);
        resultxp.put(result, xp);
    }

    public RecipesDiamondFurnace()
    {
        addRecipe(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK), new ItemStack(ItemInit.MITHRIL_INGOT), 5.0f);
    }

    public ItemStack getDiamondResult(ItemStack input)
    {
        return recipeElements.get(input);
    }

    public boolean isDiamondRecipe(ItemStack input)
    {
       return recipeElements.containsKey(input);
    }


    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public HashMap<ItemStack, ItemStack> getDualSmeltingList()
    {
        return this.recipeElements;
    }

    public Float getResultXp(ItemStack result)
    {
        return this.resultxp.get(result);
    }

}
