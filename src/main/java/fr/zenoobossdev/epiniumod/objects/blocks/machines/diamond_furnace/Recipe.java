package fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace;
import com.google.common.collect.HashBiMap;
import fr.zenoobossdev.epiniumod.init.BlockInit;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

public class Recipe
{
    public static final Recipe INSTANCE = new Recipe();


    public List<ItemStack> input = new ArrayList<>();
    public List<ItemStack> result = new ArrayList<>();


    private HashBiMap <ItemStack, ItemStack> recipes = HashBiMap.create();
    private HashBiMap <ItemStack, Float> experience = HashBiMap.create();

    public Recipe()
    {
        addRecipe(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK), new ItemStack(ItemInit.MITHRIL_INGOT),2.0f );
        addRecipe(new ItemStack(Blocks.IRON_ORE), new ItemStack(Items.IRON_INGOT), 0.7f);
    }

    public void addRecipe(ItemStack in, ItemStack out, Float xp)
    {
       recipes.put(in, out);
       experience.put(out, xp);
    }

    public ItemStack getResult(ItemStack input)
    {
        //return recipes.inverse().get(input);




       if (input.isItemEqual(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK))){
            return new ItemStack(ItemInit.MITHRIL_INGOT);
        }
        else if (input.isItemEqual(new ItemStack(BlockInit.VOLCANIUM_ORE_BLOCK)))return new ItemStack(ItemInit.VOLCANIUM_ORB);
        else if (input.isItemEqual(new ItemStack(Blocks.COAL_ORE))) return new ItemStack(Items.COAL);
        else if (input.isItemEqual(new ItemStack(Blocks.IRON_ORE))) return new ItemStack(Items.IRON_INGOT);
        else if (input.isItemEqual(new ItemStack(Blocks.GOLD_ORE))) return new ItemStack(Items.GOLD_INGOT);
        else if (input.isItemEqual(new ItemStack(Blocks.QUARTZ_ORE))) return new ItemStack(Items.QUARTZ);
        else if (input.isItemEqual(new ItemStack(Blocks.DIAMOND_ORE))) return new ItemStack(Items.DIAMOND);
        else if (input.isItemEqual(new ItemStack(Blocks.REDSTONE_ORE))) return new ItemStack(Items.REDSTONE);
        else if (input.isItemEqual(new ItemStack(Blocks.EMERALD_ORE))) return new ItemStack(Items.EMERALD);
        else if (input.isItemEqual(new ItemStack(Items.PORKCHOP))) return new ItemStack(Items.COOKED_PORKCHOP);
        else if (input.isItemEqual(new ItemStack(Items.BEEF))) return new ItemStack(Items.COOKED_BEEF);
        else if (input.isItemEqual(new ItemStack(Items.CHICKEN))) return new ItemStack(Items.COOKED_CHICKEN);
        else if (input.isItemEqual(new ItemStack(Items.FISH))) return new ItemStack(Items.COOKED_FISH);
        else if (input.isItemEqual(new ItemStack(Items.RABBIT))) return new ItemStack(Items.COOKED_RABBIT);
        else if (input.isItemEqual(new ItemStack(Items.POTATO))) return new ItemStack(Items.BAKED_POTATO);
        else if (input.isItemEqual(new ItemStack(Items.MUTTON))) return new ItemStack(Items.COOKED_MUTTON);
        else if (input.isItemEqual(new ItemStack(Items.MUTTON))) return new ItemStack(Items.COOKED_MUTTON);
        else if (input.isItemEqual(new ItemStack(Blocks.SAND))) return new ItemStack(Blocks.GLASS);
        else if (input.isItemEqual(new ItemStack(Blocks.COBBLESTONE))) return new ItemStack(Blocks.STONE);
        else if (input.isItemEqual(new ItemStack(Items.CLAY_BALL))) return new ItemStack(Items.BRICK);
        else if (input.isItemEqual(new ItemStack(Blocks.NETHERRACK))) return new ItemStack(Items.NETHERBRICK);
        else if (input.isItemEqual(new ItemStack(Blocks.LOG))) return new ItemStack(Items.COAL, 1, 1);
        else if (input.isItemEqual(new ItemStack(Blocks.LOG2))) return new ItemStack(Items.COAL, 1, 1);
        else if (input.isItemEqual(new ItemStack(Blocks.CACTUS))) return new ItemStack(Items.DYE,1,2);




        return ItemStack.EMPTY;

    }

    public boolean isKeyExist(ItemStack stack)
    {
        if (stack != null)
        {
            for (ItemStack input : this.recipes.keySet())
            {
                if (stack.isItemEqual(input))
                {
                    return true;
                }
            }
        }

        return false;
    }
}