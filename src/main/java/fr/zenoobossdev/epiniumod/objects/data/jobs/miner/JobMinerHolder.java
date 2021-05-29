package fr.zenoobossdev.epiniumod.objects.data.jobs.miner;

import com.google.common.collect.Lists;
import fr.zenoobossdev.epiniumod.init.BlockInit;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;


public class JobMinerHolder implements IJobMiner {

    protected int xp;

    protected int level;


    private List<Integer> xpLevel = new ArrayList<>();



    //xp nécessaire au level up
    int level1 = 200;
    int level2 = 600;
    int level3 = 1450;
    int level4 = 2500;
    int level5 = 3900;
    int level6 = 6250;
    int level7 = 9325;
    int level8 = 11950;
    int level9 = 14000;
    int level10 = 19000;
    int level11 = 24500;
    int level12 = 30000;
    int level13 = 37500;
    int level14 = 45650;
    int level15 = 52500;
    int level16 = 65000;
    int level17 = 78500;
    int level18 = 90000;
    int level19 = 112000;
    int level20 = 150000;

    //pourcentage de réduction à chaque levelUp
    float firstLevelReduction = (float)85/100;
    float secondLevelReduction = (float)70/100;
    float thirdLevelReduction = (float)55/100;
    float fourthLevelReduction = (float)40/100;
    float fifthLevelReduction = (float)15/100;

    //Valeur de base de chaque minerai
    public int stoneBaseXp = 2;
    public int coalBaseXp = 10;
    public int ironBaseXp = 20;
    public int quartzBaseXp = 30;
    public int goldBaseXp = 55;
    public int diamondBaseXp = 77;
    public int mithrilBaseXp = 100;
    public int volcaniumBaseXp = 150;

    //Stone
    public  float stoneFirstLevel = stoneBaseXp*firstLevelReduction;
    public  float stoneSecondLevel = stoneBaseXp*secondLevelReduction;
    public float stoneThirdLevel = stoneBaseXp*thirdLevelReduction;
    public float stoneFourthLevel = stoneBaseXp*fourthLevelReduction;
    public  float stoneFifthLevel = stoneBaseXp*fifthLevelReduction;

    //Coal
    public float coalFirstLevel = coalBaseXp*firstLevelReduction;
    public  float coalSecondLevel = coalBaseXp*secondLevelReduction;
    public float coalThirdLevel = coalBaseXp*thirdLevelReduction;
    public float coalFourthLevel = coalBaseXp*fourthLevelReduction;
    public  float coalFifthLevel = coalBaseXp*fifthLevelReduction;

    //Iron
    public  float ironFirstLevel = ironBaseXp*firstLevelReduction;
    public float ironSecondLevel = ironBaseXp*secondLevelReduction;
    public  float ironThirdLevel = ironBaseXp*thirdLevelReduction;
    public float ironFourthLevel =ironBaseXp*fourthLevelReduction;
    public float ironFifthLevel = ironBaseXp*fifthLevelReduction;

    //Quartz
    public float quartzFirstLevel = quartzBaseXp*firstLevelReduction;
    public float quartzSecondLevel = quartzBaseXp*secondLevelReduction;
    public float quartzThirdLevel = quartzBaseXp*thirdLevelReduction;
    public  float quartzFourthLevel = quartzBaseXp*fourthLevelReduction;
    public float quartzFifthLevel = quartzBaseXp*fifthLevelReduction;

    //Gold
    public float goldFirstLevel = goldBaseXp*firstLevelReduction;
    public  float goldSecondLevel = goldBaseXp*secondLevelReduction;
    public  float goldThirdLevel = goldBaseXp*thirdLevelReduction;
    public float goldFourthLevel = goldBaseXp*fourthLevelReduction;
    public  float goldFifthLevel = goldBaseXp*fifthLevelReduction;

    //Diamond
    public  float diamondFirstLevel = diamondBaseXp*firstLevelReduction;
    public  float diamondSecondLevel = diamondBaseXp*secondLevelReduction;
    public  float diamondThirdLevel = diamondBaseXp*thirdLevelReduction;
    public  float diamondFourthLevel = diamondBaseXp*fourthLevelReduction;
    public  float diamondFifthLevel = diamondBaseXp*fifthLevelReduction;

    //Mithril
    public  float mithrilFirstLevel = mithrilBaseXp*firstLevelReduction;
    public  float mithrilSecondLevel = quartzBaseXp*secondLevelReduction;
    public  float mithrilThirdLevel = quartzBaseXp*thirdLevelReduction;
    public  float mithrilFourthLevel = quartzBaseXp*fourthLevelReduction;
    public  float mithrilFifthLevel = quartzBaseXp*fifthLevelReduction;

    //Volcanium
    public  float volcaniumFirstLevel = volcaniumBaseXp*firstLevelReduction;
    public  float volcaniumSecondLevel = volcaniumBaseXp*secondLevelReduction;
    public  float volcaniumThirdLevel = volcaniumBaseXp*thirdLevelReduction;
    public  float volcaniumFourthLevel = volcaniumBaseXp*fourthLevelReduction;
    public  float volcaniumFifthLevel = volcaniumBaseXp*30/100;
    public float volcaniumSixthLevel = volcaniumBaseXp*fifthLevelReduction;

    public JobMinerHolder()
    {
        this.xp = 0;
        this.level = 0;
        this.xpLevel.add(level1);
        this.xpLevel.add(level2);
        this.xpLevel.add(level3);
        this.xpLevel.add(level4);
        this.xpLevel.add(level5);
        this.xpLevel.add(level6);
        this.xpLevel.add(level7);
        this.xpLevel.add(level8);
        this.xpLevel.add(level9);
        this.xpLevel.add(level10);
        this.xpLevel.add(level11);
        this.xpLevel.add(level12);
        this.xpLevel.add(level13);
        this.xpLevel.add(level14);
        this.xpLevel.add(level15);
        this.xpLevel.add(level16);
        this.xpLevel.add(level17);
        this.xpLevel.add(level18);
        this.xpLevel.add(level19);
        this.xpLevel.add(level20);
    }


    public int getXp() {
        return this.xp;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public void setXp(int value) {
        this.xp = value;
    }

    @Override
    public void setLevel(int value) {
        this.level = value;
    }

    public int getXpLevelUp()
    {
        return this.xpLevel.get(level);
    }

    @Override
    public float getXpForItem(ItemStack input)
    {
        if (level==0)
        {
            if (input.isItemEqual(new ItemStack(Blocks.STONE)))return stoneBaseXp;
        }
        if (level==1)
        {
            if (input.isItemEqual(new ItemStack(Blocks.STONE)))return stoneFirstLevel;
            if (input.isItemEqual(new ItemStack(Items.COAL)))return coalBaseXp;
            if (input.isItemEqual(new ItemStack(Blocks.COAL_ORE)))return coalBaseXp;
        }
        if (level==2)
        {
            if (input.isItemEqual(new ItemStack(Blocks.STONE)))return stoneSecondLevel;
            if (input.isItemEqual(new ItemStack(Blocks.COAL_ORE)))return coalFirstLevel;
            if (input.isItemEqual(new ItemStack(Items.COAL)))return coalFirstLevel;
        }
        if (level==3)
        {
            if (input.isItemEqual(new ItemStack(Blocks.STONE)))return stoneThirdLevel;
            if (input.isItemEqual(new ItemStack(Items.COAL)))return coalSecondLevel;
            if (input.isItemEqual(new ItemStack(Blocks.COAL_ORE)))return coalSecondLevel;
            if (input.isItemEqual(new ItemStack(Items.IRON_INGOT)))return ironBaseXp;
        }
        if (level==4)
        {
            if (input.isItemEqual(new ItemStack(Blocks.STONE)))return stoneFourthLevel;
            if (input.isItemEqual(new ItemStack(Blocks.COAL_ORE)))return coalThirdLevel;
            if (input.isItemEqual(new ItemStack(Items.COAL)))return coalThirdLevel;
            if (input.isItemEqual(new ItemStack(Items.IRON_INGOT)))return ironFirstLevel;
        }
        if (level==5)
        {
            if (input.isItemEqual(new ItemStack(Blocks.STONE)))return stoneFifthLevel;
            if (input.isItemEqual(new ItemStack(Blocks.COAL_ORE)))return coalFourthLevel;
            if (input.isItemEqual(new ItemStack(Items.COAL)))return coalFourthLevel;
            if (input.isItemEqual(new ItemStack(Items.IRON_INGOT)))return ironSecondLevel;
            if (input.isItemEqual(new ItemStack(Blocks.QUARTZ_ORE)))return quartzBaseXp;
            if (input.isItemEqual(new ItemStack(Items.QUARTZ)))return quartzBaseXp;
        }
        if (level==6)
        {
            if (input.isItemEqual(new ItemStack(Blocks.COAL_ORE)))return coalFifthLevel;
            if (input.isItemEqual(new ItemStack(Items.COAL)))return coalFifthLevel;
            if (input.isItemEqual(new ItemStack(Items.IRON_INGOT)))return ironThirdLevel;
            if (input.isItemEqual(new ItemStack(Blocks.QUARTZ_ORE)))return quartzFirstLevel;
            if (input.isItemEqual(new ItemStack(Items.QUARTZ)))return quartzFirstLevel;
        }
        if (level== 7)
        {
            if (input.isItemEqual(new ItemStack(Items.IRON_INGOT)))return ironFourthLevel;
            if (input.isItemEqual(new ItemStack(Blocks.QUARTZ_ORE)))return quartzSecondLevel;
            if (input.isItemEqual(new ItemStack(Items.QUARTZ)))return quartzSecondLevel;
            if (input.isItemEqual(new ItemStack(Items.GOLD_INGOT)))return goldBaseXp;
        }
        if (level==8)
        {
            if (input.isItemEqual(new ItemStack(Items.IRON_INGOT)))return ironFifthLevel;
            if (input.isItemEqual(new ItemStack(Blocks.QUARTZ_ORE)))return quartzThirdLevel;
            if (input.isItemEqual(new ItemStack(Items.QUARTZ)))return quartzThirdLevel;
            if (input.isItemEqual(new ItemStack(Items.GOLD_INGOT)))return goldFirstLevel;
        }
        if (level==9)
        {
            if (input.isItemEqual(new ItemStack(Blocks.QUARTZ_ORE)))return quartzFourthLevel;
            if (input.isItemEqual(new ItemStack(Items.QUARTZ)))return quartzFourthLevel;
            if (input.isItemEqual(new ItemStack(Items.GOLD_INGOT)))return goldSecondLevel;
            if (input.isItemEqual(new ItemStack(Blocks.DIAMOND_ORE)))return diamondBaseXp;
            if (input.isItemEqual(new ItemStack(Items.DIAMOND)))return diamondBaseXp;
        }
        if (level==10)
        {
            if (input.isItemEqual(new ItemStack(Blocks.QUARTZ_ORE)))return quartzFifthLevel;
            if (input.isItemEqual(new ItemStack(Items.QUARTZ)))return quartzFifthLevel;
            if (input.isItemEqual(new ItemStack(Items.GOLD_INGOT)))return goldThirdLevel;
            if (input.isItemEqual(new ItemStack(Blocks.DIAMOND_ORE)))return diamondFirstLevel;
            if (input.isItemEqual(new ItemStack(Items.DIAMOND)))return diamondFirstLevel;
        }
        if (level==11)
        {
            if (input.isItemEqual(new ItemStack(Items.GOLD_INGOT)))return goldFourthLevel;
            if (input.isItemEqual(new ItemStack(Blocks.DIAMOND_ORE)))return diamondSecondLevel;
            if (input.isItemEqual(new ItemStack(Items.DIAMOND)))return diamondSecondLevel;
            if (input.isItemEqual(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK)))return mithrilBaseXp;
            if (input.isItemEqual(new ItemStack(ItemInit.MITHRIL_INGOT)))return mithrilBaseXp;
        }
        if (level==12)
        {
            if (input.isItemEqual(new ItemStack(Items.GOLD_INGOT)))return goldFifthLevel;
            if (input.isItemEqual(new ItemStack(Blocks.DIAMOND_ORE)))return diamondThirdLevel;
            if (input.isItemEqual(new ItemStack(Items.DIAMOND)))return diamondThirdLevel;
            if (input.isItemEqual(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK)))return mithrilFirstLevel;
            if (input.isItemEqual(new ItemStack(ItemInit.MITHRIL_INGOT)))return mithrilFirstLevel;
        }
        if (level==13)
        {
            if (input.isItemEqual(new ItemStack(Blocks.DIAMOND_ORE)))return diamondFourthLevel;
            if (input.isItemEqual(new ItemStack(Items.DIAMOND)))return diamondFourthLevel;
            if (input.isItemEqual(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK)))return mithrilSecondLevel;
            if (input.isItemEqual(new ItemStack(ItemInit.MITHRIL_INGOT)))return mithrilSecondLevel;
            if (input.isItemEqual(new ItemStack(BlockInit.VOLCANIUM_ORE_BLOCK)))return volcaniumBaseXp;
            if (input.isItemEqual(new ItemStack(ItemInit.VOLCANIUM_ORB)))return volcaniumBaseXp;
        }
        if (level==14)
        {
            if (input.isItemEqual(new ItemStack(Blocks.DIAMOND_ORE)))return diamondFifthLevel;
            if (input.isItemEqual(new ItemStack(Items.DIAMOND)))return diamondFifthLevel;
            if (input.isItemEqual(new ItemStack(ItemInit.MITHRIL_INGOT)))return mithrilThirdLevel;
            if (input.isItemEqual(new ItemStack(BlockInit.VOLCANIUM_ORE_BLOCK)))return volcaniumFirstLevel;
            if (input.isItemEqual(new ItemStack(ItemInit.VOLCANIUM_ORB)))return volcaniumFirstLevel;
        }
        if (level==15)
        {
            if (input.isItemEqual(new ItemStack(ItemInit.MITHRIL_INGOT)))return mithrilFourthLevel;
            if (input.isItemEqual(new ItemStack(BlockInit.VOLCANIUM_ORE_BLOCK)))return volcaniumSecondLevel;
            if (input.isItemEqual(new ItemStack(ItemInit.VOLCANIUM_ORB)))return volcaniumSecondLevel;

        }
        if (level==16)
        {
            if (input.isItemEqual(new ItemStack(ItemInit.MITHRIL_INGOT)))return mithrilFifthLevel;
            if (input.isItemEqual(new ItemStack(BlockInit.VOLCANIUM_ORE_BLOCK)))return volcaniumThirdLevel;
            if (input.isItemEqual(new ItemStack(ItemInit.VOLCANIUM_ORB)))return volcaniumThirdLevel;
        }
        if (level==17)
        {
            if (input.isItemEqual(new ItemStack(BlockInit.VOLCANIUM_ORE_BLOCK)))return volcaniumFourthLevel;
            if (input.isItemEqual(new ItemStack(ItemInit.VOLCANIUM_ORB)))return volcaniumFourthLevel;
        }
        if (level==18)
        {
            if (input.isItemEqual(new ItemStack(BlockInit.VOLCANIUM_ORE_BLOCK)))return volcaniumFifthLevel;
            if (input.isItemEqual(new ItemStack(ItemInit.VOLCANIUM_ORB)))return volcaniumFifthLevel;
        }
        if (level==19)
        {
            if (input.isItemEqual(new ItemStack(BlockInit.VOLCANIUM_ORE_BLOCK)))return volcaniumSixthLevel;
            if (input.isItemEqual(new ItemStack(ItemInit.VOLCANIUM_ORB)))return volcaniumSixthLevel;
        }
        return 0;
    }


    @Override
   public  ItemStack getDrop(ItemStack input, World w){
        if (!w.isRemote)
        if (input.isItemEqual(new ItemStack(Blocks.IRON_ORE))) return new ItemStack(Items.IRON_INGOT);
        if (input.isItemEqual(new ItemStack(Blocks.GOLD_ORE))) return new ItemStack(Items.GOLD_INGOT);
        if (input.isItemEqual(new ItemStack(BlockInit.MITHRIL_ORE_BLOCK))) return new ItemStack(ItemInit.MITHRIL_INGOT);
        else return ItemStack.EMPTY;

    }

    @Override
    public List<String> howToXp(){
        List<String> list = new ArrayList<>();
        list.clear();
        if (level<6)list.add("stone");
        if (level>0&&level<7)list.add("coal");
        if (level>2&&level<9)list.add("iron");
        if (level>4&&level<11)list.add("quartz");
        if (level>6&&level<13)list.add("gold");
        if (level>8&&level<15)list.add("diamond");
        if (level>10&&level<17)list.add("mithril");
        if (level>12&&level<19)list.add("volcanium");
        return list;
    }
    public boolean drop = false;

    @Override
    public void setDrop(boolean b){
        this.drop=b;
    }

    @Override
    public boolean getDrop(){
        return this.drop;
    }

}
