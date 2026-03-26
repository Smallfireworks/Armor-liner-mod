package com.ignilumen.armor_liner.item;

import com.mojang.serialization.Codec;

public record ArmorLining(LiningType type) {
    public static final Codec<ArmorLining> CODEC = LiningType.CODEC.xmap(ArmorLining::new, ArmorLining::type);

    public int temperatureModifier() {
        return type.temperatureModifier();
    }
}
