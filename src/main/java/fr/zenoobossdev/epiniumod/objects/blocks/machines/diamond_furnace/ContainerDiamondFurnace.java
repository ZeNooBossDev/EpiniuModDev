package fr.zenoobossdev.epiniumod.objects.blocks.machines.diamond_furnace;

import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerDiamondFurnace extends Container {
	private final TileEntityDiamondFurnace tileentity;
	private int cookTime, totalCookTime, burnTime, currentBurnTime;

	public ContainerDiamondFurnace(InventoryPlayer player, TileEntityDiamondFurnace tileentity, EntityPlayer entityPlayer) {
		this.tileentity = tileentity;
		IItemHandler handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		this.addSlotToContainer(new SlotItemHandler(handler, 0, 26, 11));
		this.addSlotToContainer(new SlotItemHandler(handler, 1, 26, 59));
		this.addSlotToContainer(new SlotItemHandler(handler, 2, 81, 36));

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}

		for (int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
		}
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i) {
			IContainerListener listener = (IContainerListener) this.listeners.get(i);

			if (this.cookTime != this.tileentity.getField(2))
				listener.sendWindowProperty(this, 2, this.tileentity.getField(2));
			if (this.burnTime != this.tileentity.getField(0))
				listener.sendWindowProperty(this, 0, this.tileentity.getField(0));
			if (this.currentBurnTime != this.tileentity.getField(1))
				listener.sendWindowProperty(this, 1, this.tileentity.getField(1));
			if (this.totalCookTime != this.tileentity.getField(3))
				listener.sendWindowProperty(this, 3, this.tileentity.getField(3));
		}

		this.cookTime = this.tileentity.getField(2);
		this.burnTime = this.tileentity.getField(0);
		this.currentBurnTime = this.tileentity.getField(1);
		this.totalCookTime = this.tileentity.getField(3);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		this.tileentity.setField(id, data);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tileentity.isUsableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack stackToReturn = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		IJobMiner capability = playerIn.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);



		if (slot != null && slot.getHasStack()) {
			ItemStack stack = slot.getStack();
			stackToReturn = stack.copy();

			if (index<3){
				if (!this.mergeItemStack(stack, 3, 39, true)){
					return ItemStack.EMPTY;
				}
			}else if (!this.mergeItemStack(stack, 0, 3, false)){
				return ItemStack.EMPTY;
			}

			if (stack.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

		}
		for (int i = 1; i<=stackToReturn.getCount(); i++){
			capability.increaseXp((int)capability.getXpForItem(new ItemStack(stackToReturn.getItem())));
			System.out.println("Xp : "+capability.getXp());
			System.out.println("Level : "+capability.getLevel());
			System.out.println("Count : " + capability);

		}
		return stackToReturn;
	}




}