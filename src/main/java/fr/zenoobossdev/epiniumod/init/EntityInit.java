package fr.zenoobossdev.epiniumod.init;

import fr.zenoobossdev.epiniumod.Main;
import fr.zenoobossdev.epiniumod.objects.entities.EntityVolcanoZombie;
import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit
{
    public static void registerEntities()
    {
        registerEntity("volcano_zombie", EntityVolcanoZombie.class, Reference.ENTITY_VOLCANO_ZOMBIE, 50, 11437146, 000000);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
    }
}
