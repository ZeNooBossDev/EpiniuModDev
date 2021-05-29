package fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace;

import fr.zenoobossdev.epiniumod.init.BlockInit;
import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace.RecipesDiamondFurnace;

public class TileEntityDiamondFurnace extends TileEntity implements ITickable, IInventory
{
    private ItemStackHandler handler = new ItemStackHandler(3);
    private String customName;
    private ItemStack smelting = ItemStack.EMPTY;
    private ItemStack[] contents = new ItemStack[4];
    private EntityPlayer entityPlayer;


    private int burnTime;
    private int currentBurnTime;
    private int cookTime;
    private int totalCookTime = 50;



    public EntityPlayer getPlayer(EntityPlayer player)
    {
        return player;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        else return false;
    }


    @Override
    public int getSizeInventory() {
        return this.contents.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getStackInSlot(int slotIndex) {
        return this.contents[slotIndex];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {

    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.handler;
        return super.getCapability(capability, facing);
    }

    @Override
    public String getName() {
        return null;
    }

    public boolean hasCustomName()
    {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return this.hasCustomName() ? new TextComponentString(this.customName) : new TextComponentTranslation("container.diamond_furnace");
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
        this.burnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentBurnTime = getItemBurnTime((ItemStack)this.handler.getStackInSlot(2));

        if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short)this.burnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
        compound.setTag("Inventory", this.handler.serializeNBT());

        if(this.hasCustomName()) compound.setString("CustomName", this.customName);
        return compound;
    }

    public boolean isBurning()
    {
        return this.burnTime > 0;
    }


    @SideOnly(Side.CLIENT)
    public static boolean isBurning(TileEntityDiamondFurnace te)
    {
        return te.getField(0) > 0;
    }


    public void update()
    {
        int isItemInSlotOutput = 0;
        if(this.isBurning())
        {ItemStack input = this.handler.getStackInSlot(0);
            --this.burnTime;
            BlockDiamondFurnace.setState(true, world, pos);
        }

        ItemStack fuel = this.handler.getStackInSlot(1);

        if(this.isBurning() || !fuel.isEmpty() && !this.handler.getStackInSlot(0).isEmpty())
        {ItemStack input = this.handler.getStackInSlot(0);
            if(!this.isBurning() && this.canSmelt())
            {input= this.handler.getStackInSlot(0);
                this.burnTime = getItemBurnTime(fuel);
                this.currentBurnTime = burnTime;

                if(this.isBurning() && !fuel.isEmpty())
                {input= this.handler.getStackInSlot(0);
                    Item item = fuel.getItem();
                    fuel.shrink(1);

                    if(fuel.isEmpty())
                    {input= this.handler.getStackInSlot(0);
                        ItemStack item1 = item.getContainerItem(fuel);
                        this.handler.setStackInSlot(1, item1);
                    }
                }
            }
        }

        if (this.isBurning() && this.handler.getStackInSlot(0).isEmpty()){
            cookTime = 0;
        }

        if(this.isBurning() && this.canSmelt() && cookTime > 0)
        {ItemStack input= this.handler.getStackInSlot(0);
            cookTime++;
            if(cookTime == totalCookTime)
            {
                if(handler.getStackInSlot(2).getCount() > 0)
                {input= this.handler.getStackInSlot(0);
                    input.shrink(1);
                    handler.getStackInSlot(2).grow(1);
                }
                else
                {input= this.handler.getStackInSlot(0);
                    input.shrink(1);
                    handler.insertItem(2, smelting, false);
                }

                cookTime = 0;
                return;
            }
        }
        else
        {

            if(this.canSmelt() && this.isBurning())
            {ItemStack input= this.handler.getStackInSlot(0);
                ItemStack output = Recipe.INSTANCE.getResult(input);
                if(!output.isEmpty());
                {input= this.handler.getStackInSlot(0);
                    smelting = output;
                    cookTime++;
                    handler.setStackInSlot(0, input);
                }
            }
        }


    }

    private boolean canSmelt()
    {
        ItemStack input = this.handler.getStackInSlot(0);
        if (input.isEmpty()) return false;
        else
        {
            ItemStack result = Recipe.INSTANCE.getResult(input);
            if(result.isEmpty()) return false;
            else
            {
                ItemStack output = (ItemStack)this.handler.getStackInSlot(2);
                if(output.isEmpty()) return true;
                if (!output.isItemEqual(result)) return false;
                int res = output.getCount() + result.getCount();
                return res <= 64 && res <= output.getMaxStackSize();
            }
        }
    }



    public static int getItemBurnTime(ItemStack fuel)
    {
        if(fuel.isEmpty()) return 0;
        else
        {
            Item item = fuel.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.WOODEN_SLAB) return 150;
                if (block.getDefaultState().getMaterial() == Material.WOOD) return 300;
                if (block == Blocks.COAL_BLOCK) return 16000;
            }

            if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
            if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
            if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200;
            if (item == Items.STICK) return 100;
            if (item == Items.COAL) return 1600;
            if (item == Items.LAVA_BUCKET) return 20000;
            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
            if (item == Items.BLAZE_ROD) return 2400;

            return ForgeEventFactory.getItemBurnTime(fuel);
        }
    }

    public static boolean isItemFuel(ItemStack fuel)
    {
        return getItemBurnTime(fuel) > 0;
    }

    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 0)return true;
        if (index==1)return true;
        return false;
    }

    public int getField(int id)
    {
        switch(id)
        {
            case 0:
                return this.burnTime;
            case 1:
                return this.currentBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch(id)
        {
            case 0:
                this.burnTime = value;
                break;
            case 1:
                this.currentBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }
}