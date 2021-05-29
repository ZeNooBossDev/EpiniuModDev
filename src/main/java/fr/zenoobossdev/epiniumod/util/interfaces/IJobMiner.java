package fr.zenoobossdev.epiniumod.util.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public interface IJobMiner
{//On était à 77 xp.
    int xp=0;

    int level=0;

    boolean drop = false;

    int getXp();

    int getLevel();

    int getXpLevelUp();

    float getXpForItem(ItemStack input);

    ItemStack getDrop(ItemStack input, World w);


    default void setDrop(boolean b){}

    boolean getDrop();

    void setXp(int value);

    void setLevel(int value);

    default void reduceXp(int value)
    {
        this.setXp(this.getXp() - value);
    }

    default void reduceLevel(int value){this.setLevel(this.getLevel() - value);}

    default void increaseXp(int value)
    {
        this.setXp(this.getXp() + value);
    }

    default void increaseLevel(int value){this.setLevel(this.getLevel() + value);}

    List<String> howToXp();

}
