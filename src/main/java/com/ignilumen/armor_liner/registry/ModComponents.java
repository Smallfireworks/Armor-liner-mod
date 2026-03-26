package com.ignilumen.armor_liner.registry;

import com.ignilumen.armor_liner.ArmorLiner;
import com.ignilumen.armor_liner.item.ArmorLining;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModComponents {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, ArmorLiner.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ArmorLining>> ARMOR_LINING =
            DATA_COMPONENTS.registerComponentType("armor_lining", builder -> builder
                    .persistent(ArmorLining.CODEC)
                    .cacheEncoding());

    private ModComponents() {}

    public static void register(IEventBus eventBus) {
        DATA_COMPONENTS.register(eventBus);
    }
}
