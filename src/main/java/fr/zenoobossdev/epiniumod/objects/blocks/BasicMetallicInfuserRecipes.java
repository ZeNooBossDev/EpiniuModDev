package fr.zenoobossdev.epiniumod.objects.blocks;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import fr.zenoobossdev.epiniumod.init.BlockInit;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class BasicMetallicInfuserRecipes
{

    private static final BasicMetallicInfuserRecipes INSTANCE = new BasicMetallicInfuserRecipes();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static BasicMetallicInfuserRecipes getInstance() {

        return INSTANCE;

    }

    private BasicMetallicInfuserRecipes() {

        this.addInfuserRecipe(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK), new ItemStack(BlockInit.MITHRIL_BLOCK), new ItemStack(Blocks.ACACIA_FENCE), 5.0F);
        this.addInfuserRecipe(new ItemStack(Blocks.ACACIA_FENCE), new ItemStack(Blocks.ACACIA_FENCE_GATE), new ItemStack(ItemInit.MITHRIL_INGOT), 5.0F);

    }


    public void addInfuserRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) {

        if(getInfuserResult(input1, input2) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));

    }

    public ItemStack getInfuserResult(ItemStack input1, ItemStack input2) {

        for(Map.Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) {

            if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) {

                for(Map.Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {

                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) {

                        return (ItemStack)ent.getValue();

                    }

                }

            }

        }

        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {

        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());

    }

    public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() {

        return this.smeltingList;

    }

    public float getInfuserExperience(ItemStack stack) {

        for (Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {

            if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) {

                return ((Float)entry.getValue()).floatValue();

            }

        }

        return 0.0F;
    }
}
