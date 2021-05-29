package fr.zenoobossdev.epiniumod.objects.items;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.guis.GuiUnclaimFinder;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import fr.zenoobossdev.epiniumod.util.interfaces.IHasModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class UnclaimFinder extends Item implements IHasModel
{
    public static int dura = 90*20*60;

    private static EntityPlayer player;

    public static int percents = 0;

    public UnclaimFinder(String name)
    {
        this.addPropertyOverride(new ResourceLocation("percent"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @Override
                    public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                        return percents;
                    }
        });



    this.setMaxDamage(this.dura);
    setUnlocalizedName(name);
    setRegistryName(name);
    setCreativeTab(Main.epiniumtab);
    setMaxStackSize(1);
    ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        this.player = (EntityPlayer) entityIn;

        if (this.player.getHeldItem(EnumHand.MAIN_HAND).getItem()instanceof UnclaimFinder){
            if (this.dura >= 0){
                this.dura --;
                stack.damageItem(1, this.player);
            }
        }

        if (GuiUnclaimFinder.amountTiles <= 25){
            this.percents = GuiUnclaimFinder.amountTiles;
        }
        else if (GuiUnclaimFinder.amountTiles >= 26)
        {
            this.percents = 26;
        }

        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
