package com.ignilumen.armor_liner.registry;

import com.ignilumen.armor_liner.ArmorLiner;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ArmorLiner.MODID);

    public static final DeferredItem<Item> LINER_SNIPS =
            ITEMS.registerSimpleItem("liner_snips", new Item.Properties().stacksTo(1));

    private ModItems() {}

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
