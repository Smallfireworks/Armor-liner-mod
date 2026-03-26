package com.ignilumen.armor_liner.util;

import com.ignilumen.armor_liner.item.ArmorLining;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public final class ArmorLiningTooltipHandler {
    private ArmorLiningTooltipHandler() {}

    public static void onItemTooltip(ItemTooltipEvent event) {
        ArmorLining lining = ArmorLiningUtil.getLining(event.getItemStack());
        if (lining == null) {
            return;
        }

        event.getToolTip().add(Component.translatable(
                "tooltip.armor_liner.lined_armor",
                Component.translatable("tooltip.armor_liner." + lining.type().getSerializedName() + "_liner")
        ).withStyle(ChatFormatting.GRAY));
    }
}
