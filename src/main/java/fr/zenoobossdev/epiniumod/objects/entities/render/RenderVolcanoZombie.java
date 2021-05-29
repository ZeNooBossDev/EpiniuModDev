package fr.zenoobossdev.epiniumod.objects.entities.render;

import fr.zenoobossdev.epiniumod.objects.entities.EntityVolcanoZombie;
import fr.zenoobossdev.epiniumod.objects.entities.model.ModelVolcanoZombie;
import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVolcanoZombie extends RenderLiving<EntityVolcanoZombie>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID+":textures/entity/volcano_zombie.png");

    public RenderVolcanoZombie(RenderManager manager){
        super(manager, new ModelVolcanoZombie(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityVolcanoZombie entity){
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityVolcanoZombie entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
