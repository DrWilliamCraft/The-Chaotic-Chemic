package net.mrafton.thechaoticchemic.elements;



import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.IItemDecorator;

public class ElementItemRenderer implements IItemDecorator {

    @Override
    public boolean render(GuiGraphics guiGraphics, Font font, ItemStack stack, int xOffset, int yOffset) {
        if (!(stack.getItem() instanceof ElementItem elementItem)) {
            return false;
        }

        String text = elementItem.getData().abbreviation();
        if (text == null || text.isBlank()) {
            return false;
        }

        Font mcFont = Minecraft.getInstance().font;

        float scale = text.length() > 1 ? 0.55f : 0.75f;
        int color = 0xFFFFF000;
        int outline = 0xFF222222;

        int textWidth = mcFont.width(text);
        int drawX = xOffset + 8 - Math.round((textWidth * scale) / 2f);
        int drawY = yOffset + (text.length() > 1 ? 6 : 5);

        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        pose.translate(drawX, drawY, 200.0F);
        pose.scale(scale, scale, 1.0F);

        var matrix = pose.last().pose();
        var buffer = guiGraphics.bufferSource();

        // Outline
        mcFont.drawInBatch(text, -1,  0, outline, false, matrix, buffer, Font.DisplayMode.NORMAL, 0, 15728880);
        mcFont.drawInBatch(text,  1,  0, outline, false, matrix, buffer, Font.DisplayMode.NORMAL, 0, 15728880);
        mcFont.drawInBatch(text,  0, -1, outline, false, matrix, buffer, Font.DisplayMode.NORMAL, 0, 15728880);
        mcFont.drawInBatch(text,  0,  1, outline, false, matrix, buffer, Font.DisplayMode.NORMAL, 0, 15728880);

        // Main text
        mcFont.drawInBatch(text, 0, 0, color, false, matrix, buffer, Font.DisplayMode.NORMAL, 0, 15728880);

        pose.popPose();

        return false;
    }
}
