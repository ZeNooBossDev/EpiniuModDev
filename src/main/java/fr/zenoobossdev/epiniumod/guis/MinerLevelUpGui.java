package fr.zenoobossdev.epiniumod.guis;

import fr.zenoobossdev.epiniumod.util.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class MinerLevelUpGui extends GuiScreen
{
    int guiWidth = 248;
    int guiHeight = 80;

    ResourceLocation background = new ResourceLocation(Reference.MODID + ":textures/gui/miner_level_up_gui");

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int guiX = (this.width - guiWidth) / 2;
        int guiY = (this.height - guiHeight) / 2;

        mc.renderEngine.bindTexture(background);
        drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth+2, guiHeight+2);
        fontRenderer.drawString("Bravo !", (int) (guiX + 25), guiY + 6, 0x000000);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
