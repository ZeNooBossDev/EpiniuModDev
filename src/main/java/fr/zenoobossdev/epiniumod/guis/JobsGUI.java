package fr.zenoobossdev.epiniumod.guis;

import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.awt.*;

public class JobsGUI extends GuiScreen
{
    int guiWidth = 248;
    int guiHeight = 166;
    String label = "player";

    int jobChosen = 0;

    ResourceLocation minerButton = new ResourceLocation(Reference.MODID + ":textures/gui/miner_button");


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int guiX = (this.width - guiWidth) / 2;
        int guiY = (this.height - guiHeight) / 2;

        mc.renderEngine.bindTexture(new ResourceLocation("epiniumod:textures/gui/miner_job_gui.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth+2, guiHeight+2);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }


    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(1, (this.width - guiWidth) / 2 + 4, (this.height - guiHeight) / 2+4, 80, 20, "Miner"));
        this.jobChosen = 0;
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton b)
    {
        if(b.id == 1)
        {
            mc.player.closeScreen();
            mc.displayGuiScreen(new MinerGui());
        }
    }


}