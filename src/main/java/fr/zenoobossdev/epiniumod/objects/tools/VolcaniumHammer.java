package fr.zenoobossdev.epiniumod.objects.tools;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.init.ItemInit;
import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import fr.zenoobossdev.epiniumod.util.interfaces.IHasModel;
import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class VolcaniumHammer extends ItemPickaxe implements IHasModel
{
    public static float effiency = 12.0f;

    public VolcaniumHammer(String name, Item.ToolMaterial material, int harvestLevel)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.epiniumtab);
        ItemInit.ITEMS.add(this);
        setHarvestLevel("pickaxe", harvestLevel);
        setMaxDamage(2000);

    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }

    protected RayTraceResult rayTrace(double blockReachDistance, float partialTicks, World world, EntityLivingBase e) {
        Vec3d vec3d = e.getPositionEyes(partialTicks);
        Vec3d vec3d1 = e.getLook(partialTicks);
        Vec3d vec3d2 = vec3d.addVector(vec3d1.x*blockReachDistance, vec3d1.y*blockReachDistance, vec3d1.z*blockReachDistance);
        return world.rayTraceBlocks(vec3d, vec3d2, false, false, true);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack breaker, World w, IBlockState state, BlockPos pos, EntityLivingBase e) {
        if (e instanceof EntityPlayer && !w.isRemote){
            EntityPlayer p = (EntityPlayer) e;
            RayTraceResult r = this.rayTrace(5.0D, 0.0f, w, e);
            IJobMiner cap = e.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);
            if (!cap.getDrop(new ItemStack(state.getBlock()), w).isEmpty()){
                ((EntityPlayer) e).inventory.addItemStackToInventory(cap.getDrop((new ItemStack(state.getBlock())), w));
                cap.setDrop(true);
            }
            if (r.typeOfHit == RayTraceResult.Type.BLOCK);{
                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();

                EnumFacing side = r.sideHit;

                if (side ==  EnumFacing.DOWN || side == EnumFacing.UP){
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z - 1);
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z);
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z + 1);
                    this.destroyAndDropBlock(w, p, breaker, x, y, z - 1);
                    // Middle block
                    this.destroyAndDropBlock(w, p, breaker, x, y, z + 1);
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z - 1);
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z);
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z + 1);

                }
                // Z
                // NORTH - SOUTH
                else if(side == EnumFacing.NORTH || side == EnumFacing.SOUTH)
                {
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y + 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y + 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z);
                    // Middle block
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z);
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y - 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y - 1, z);
                }
                // X
                // EAST - WEST
                else if(side == EnumFacing.EAST || side == EnumFacing.WEST)
                {
                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z + 1);
                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z - 1);
                    this.destroyAndDropBlock(w, p, breaker, x, y, z + 1);
                    // Middle block
                    this.destroyAndDropBlock(w, p, breaker, x, y, z - 1);
                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z + 1);
                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z - 1);
                }
                return true;
            }
        }
        breaker.damageItem(1, e);
        return super.onBlockDestroyed(breaker, w, state, pos, e);
    }

    private void destroyAndDropBlock(World w, EntityPlayer p, ItemStack breaker, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);

        if (w.getBlockState(pos).getBlockHardness(w, pos) >= 0){
            IJobMiner cap = p.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null);
            cap.increaseXp((int) cap.getXpForItem(new ItemStack(w.getBlockState(pos).getBlock())));
            if (!cap.getDrop(new ItemStack(w.getBlockState(pos).getBlock()), w).isEmpty()){
                p.inventory.addItemStackToInventory(cap.getDrop(new ItemStack(w.getBlockState(pos).getBlock()), w));
                if (breaker.canHarvestBlock(w.getBlockState(pos))){
                    w.setBlockToAir(pos);
                }
            }
            else {
                w.getBlockState(pos).getBlock().harvestBlock(w, p, pos, w.getBlockState(pos), w.getTileEntity(pos), breaker);
                w.setBlockToAir(pos);
            }
        }
    }
}
