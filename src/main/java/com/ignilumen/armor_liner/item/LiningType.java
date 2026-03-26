package com.ignilumen.armor_liner.item;

import com.mojang.serialization.Codec;

import net.minecraft.util.StringRepresentable;

public enum LiningType implements StringRepresentable {
    WARMING("warming", 1),
    COOLING("cooling", -1);

    public static final Codec<LiningType> CODEC = StringRepresentable.fromEnum(LiningType::values);

    private final String serializedName;
    private final int temperatureModifier;

    LiningType(String serializedName, int temperatureModifier) {
        this.serializedName = serializedName;
        this.temperatureModifier = temperatureModifier;
    }

    @Override
    public String getSerializedName() {
        return serializedName;
    }

    public int temperatureModifier() {
        return temperatureModifier;
    }
}
