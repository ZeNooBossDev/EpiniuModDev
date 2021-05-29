package fr.zenoobossdev.epiniumod.world.generation;

import fr.zenoobossdev.epiniumod.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenCustomOres implements IWorldGenerator
{
    private WorldGenerator mithril_ore_block;
    private WorldGenerator volcanium_ore_block;

    public WorldGenCustomOres()
    {
        mithril_ore_block = new WorldGenMinable(BlockInit.MITHRIL_ORE_BLOCK.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
        volcanium_ore_block = new WorldGenMinable(BlockInit.VOLCANIUM_ORE_BLOCK.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
    }



    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.getDimension())
        {
            case -1:
                break;
            case 0:
                runGenerator(mithril_ore_block, world, random, chunkX, chunkZ, 13, 2, 22);
                runGenerator(volcanium_ore_block, world, random, chunkX, chunkZ, 10, 2, 12);
                break;
            case 1:
                break;
        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
    {
        if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");

        int heightDiff = maxHeight - minHeight + 1;

        for (int i = 0; i < chance; i ++)
        {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            gen.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}
