package fr.zenoobossdev.epiniumod.guis;

import fr.zenoobossdev.epiniumod.objects.data.jobs.miner.JobMinerWrapper;
import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class MinerGui extends GuiScreen
{
    int guiWidth = 248;
    int guiHeight = 166;

    int xp;
    int xpToLevelUp;
    int level;
    int percentageXp;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int guiX = (this.width - guiWidth) / 2;
        int guiY = (this.height - guiHeight) / 2;

        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID+ ":textures/gui/job_miner_empty.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth+2, guiHeight+2);
        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID+ ":textures/gui/jobs_progress_bar.png"));
        drawTexturedModalRect(guiX+14, guiY+63, 0, 0, this.percentageXp, 9);
        fontRenderer.drawString("xp : "+this.xp, guiX+14, guiY+80, 1);



        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
       this.xp = mc.player.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null).getXp();
       this.xpToLevelUp = mc.player.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null).getXpLevelUp();
       this.level = mc.player.getCapability(JobMinerWrapper.JOB_MINER_CAPABILITY, null).getLevel();
       this.percentageXp = xp / xpToLevelUp * 218;
       super.initGui();
    }
}
