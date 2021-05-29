package fr.zenoobossdev.epiniumod.util.interfaces;

import net.minecraft.item.ItemStack;

import java.util.List;

public interface IJobMinerLevel {


        int xp=0;

        int level=0;

        int getXp();

        int getLevel();

        int getXpLevelUp();

        float getXpForItem(ItemStack input);

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
