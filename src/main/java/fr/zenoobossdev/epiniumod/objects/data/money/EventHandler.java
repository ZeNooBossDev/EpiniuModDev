package fr.zenoobossdev.epiniumod.objects.data.money;

import fr.zenoobossdev.epiniumod.init.BlockInit;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import fr.zenoobossdev.epiniumod.util.Reference;
import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;
import ibxm.Player;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MODID)
public class EventHandler
{
    int xp;
    int level;

    @SubscribeEvent
    public void onPlayerCloned(PlayerEvent.Clone event)
    {

            EntityPlayer player = event.getEntityPlayer();
            IJobMiner xp = player.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);
            IJobMiner oldXp = event.getOriginal().getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);
            IJobMiner level = player.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);
            IJobMiner oldLevel = event.getOriginal().getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);

            xp.setXp(oldXp.getXp());
            this.xp=(int)oldXp.getXp();
            level.setLevel(oldLevel.getLevel());
            this.level=(int)oldLevel.getXp();

    }





    @SubscribeEvent
    public static void playerTickUpdate(TickEvent.PlayerTickEvent event)
    {IJobMiner jobMiner = event.player.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);
        int level = jobMiner.getLevel();
        InventoryPlayer inventory = event.player.inventory;

        List<ItemStack> list = new ArrayList<>();
        ItemStack level1 = new ItemStack(Items.IRON_PICKAXE);
        level1.addEnchantment(Enchantments.EFFICIENCY, 1);
        list.add(level1);

        ItemStack level2 = new ItemStack(Items.IRON_PICKAXE);
        level2.addEnchantment(Enchantments.EFFICIENCY, 2);
        level2.addEnchantment(Enchantments.UNBREAKING, 1);
        list.add(level2);

        ItemStack level3 = new ItemStack(Items.IRON_PICKAXE);
        level3.addEnchantment(Enchantments.EFFICIENCY, 3);
        level3.addEnchantment(Enchantments.UNBREAKING, 3);
        list.add(level3);

        ItemStack level4 = new ItemStack(Items.DIAMOND_PICKAXE);
        level4.addEnchantment(Enchantments.EFFICIENCY, 1);
        list.add(level4);

        ItemStack level5 = new ItemStack(Items.DIAMOND_PICKAXE);
        level5.addEnchantment(Enchantments.EFFICIENCY, 2);
        level5.addEnchantment(Enchantments.UNBREAKING, 1);
        list.add(level5);

        ItemStack level6 = new ItemStack(Items.IRON_PICKAXE);
        level6.addEnchantment(Enchantments.EFFICIENCY, 3);
        level6.addEnchantment(Enchantments.UNBREAKING, 3);
        list.add(level6);

        ItemStack level7 = new ItemStack(ItemInit.MITHRIL_PICKAXE);
        level4.addEnchantment(Enchantments.EFFICIENCY, 1);
        list.add(level7);

        ItemStack level8 = new ItemStack(ItemInit.MITHRIL_PICKAXE);
        level5.addEnchantment(Enchantments.EFFICIENCY, 2);
        level5.addEnchantment(Enchantments.UNBREAKING, 1);
        list.add(level8);

        ItemStack level9 = new ItemStack(ItemInit.MITHRIL_PICKAXE);
        level6.addEnchantment(Enchantments.EFFICIENCY, 3);
        level6.addEnchantment(Enchantments.UNBREAKING, 3);
        list.add(level9);

        ItemStack level10 = new ItemStack(ItemInit.VOLCANIUM_PICKAXE);
        level4.addEnchantment(Enchantments.EFFICIENCY, 1);
        list.add(level10);

        ItemStack level11 = new ItemStack(ItemInit.VOLCANIUM_PICKAXE);
        level5.addEnchantment(Enchantments.EFFICIENCY, 2);
        level5.addEnchantment(Enchantments.UNBREAKING, 1);
        list.add(level11);

        ItemStack level12 = new ItemStack(ItemInit.VOLCANIUM_PICKAXE);
        level6.addEnchantment(Enchantments.EFFICIENCY, 3);
        level6.addEnchantment(Enchantments.UNBREAKING, 3);
        list.add(level12);

        ItemStack level13 = new ItemStack(ItemInit.VOLCANIUM_PICKAXE);
        level6.addEnchantment(Enchantments.EFFICIENCY, 4);
        level6.addEnchantment(Enchantments.UNBREAKING, 3);
        list.add(level13);

        ItemStack level14 = new ItemStack(ItemInit.VOLCANIUM_PICKAXE);
        level6.addEnchantment(Enchantments.EFFICIENCY, 5);
        level6.addEnchantment(Enchantments.UNBREAKING, 3);
        list.add(level14);

        ItemStack level15 = ItemStack.EMPTY;
        list.add(level15);
        ItemStack level16 = ItemStack.EMPTY;
        list.add(level16);
        ItemStack level17 = ItemStack.EMPTY;
        list.add(level17);
        ItemStack level18 = ItemStack.EMPTY;
        list.add(level18);
        ItemStack level19 = ItemStack.EMPTY;
        list.add(level19);
        ItemStack level20 = ItemStack.EMPTY;
        list.add(level20);


        if(!event.player.getEntityWorld().isRemote)
        {

            if (jobMiner.getXp()>= jobMiner.getXpLevelUp())
            {
                inventory.addItemStackToInventory(list.get(level));
                for (int i=0; i<=level; i++){
                    inventory.addItemStackToInventory(new ItemStack(ItemInit.MONEY));
                }
                jobMiner.reduceXp(jobMiner.getXpLevelUp());
                jobMiner.increaseLevel(1);
            }
        }

    }



    @SubscribeEvent
    public static void itemSmelted(net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent event) {

        if (!event.player.getEntityWorld().isRemote)
        {
            IJobMiner jobMiner = event.player.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);
            ItemStack input = new ItemStack(event.smelting.getItem());
            int nbStackInSlot = event.smelting.getCount();


            for (int i = 1; i<=nbStackInSlot; i++){
                jobMiner.increaseXp((int)jobMiner.getXpForItem(input));
                System.out.println("Xp : "+jobMiner.getXp());
                System.out.println("Level : "+jobMiner.getLevel());
                System.out.println("Count : " + nbStackInSlot);

            }

        }

    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event)
    {
        ItemStack block = new ItemStack(event.getWorld().getBlockState(event.getPos()).getBlock());
        ItemStack currentItem = event.getPlayer().inventory.getCurrentItem();
        List<ItemStack> forbiddenItemstack = new ArrayList<>();
        forbiddenItemstack.add(new ItemStack(Blocks.IRON_ORE));
        forbiddenItemstack.add(new ItemStack(Blocks.GOLD_ORE));
        forbiddenItemstack.add(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK));


        if (currentItem.canHarvestBlock(event.getWorld().getBlockState(event.getPos())))
        {
            IJobMiner capability = event.getPlayer().getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);
            Map map =  EnchantmentHelper.getEnchantments(currentItem);
            if (!map.containsKey(Enchantments.SILK_TOUCH))
            {
                if (!forbiddenItemstack.contains(block)){
                capability.increaseXp((int)capability.getXpForItem(block));
            }

        }

        }

    }

    @SubscribeEvent
    public static void onDrop(EntityItemPickupEvent e){
        EntityPlayer player = e.getEntityPlayer();
        IJobMiner cap = player.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);

        if (cap.getDrop()){
            for (int i=0; i<=player.inventory.getSizeInventory(); i++){
                if (player.inventory.getStackInSlot(i).isItemEqual(new ItemStack(Blocks.GOLD_ORE))){
                    player.inventory.decrStackSize(i, 1);
                }
                if (player.inventory.getStackInSlot(i).isItemEqual(new ItemStack(Blocks.IRON_ORE))){
                    player.inventory.decrStackSize(i, 1);
                }
                if (player.inventory.getStackInSlot(i).isItemEqual(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK))){
                    player.inventory.decrStackSize(i, 1);
                }
            }
        }
    }


}
