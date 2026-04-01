package net.mrafton.thechaoticchemic.elements;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ElementItem extends Item {
    private final ElementData data;

    public ElementItem(Properties properties, ElementData data) {
        super(properties);
        this.data = data;
    }

    public String getSymbol(){
        return data.abbreviation();
    }
    public int getTintColor() {
        if (data.color() == null || data.color().isBlank()) {
            return 0xFFFFFFFF;
        }

        try {
            return Integer.parseInt(data.color(), 16) | 0xFF000000;
        } catch (NumberFormatException e) {
            return 0xFFFFFFFF;
        }
    }



    public ElementData getData() {
        return data;
    }
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("Symbol: " + data.abbreviation()).withStyle(ChatFormatting.YELLOW));
        tooltip.add(Component.literal("Atomic Number: " + data.atomicNumber()).withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.literal("Group: " + data.group()).withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.literal("Period: " + data.period()).withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.literal("State: " + data.matterState().name().toLowerCase()).withStyle(ChatFormatting.AQUA));
        tooltip.add(Component.literal("Type: " + data.metalType().name().toLowerCase()).withStyle(ChatFormatting.DARK_GREEN));

        if (data.artificial()) {
            tooltip.add(Component.literal("Artificial").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }
}
