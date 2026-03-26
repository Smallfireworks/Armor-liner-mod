package com.ignilumen.armor_liner;

import com.ignilumen.armor_liner.compat.ToughAsNailsCompat;
import com.ignilumen.armor_liner.registry.ModComponents;
import com.ignilumen.armor_liner.registry.ModItems;
import com.ignilumen.armor_liner.registry.ModRecipeSerializers;
import com.ignilumen.armor_liner.util.ArmorLiningTooltipHandler;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(ArmorLiner.MODID)
public final class ArmorLiner {
    public static final String MODID = "armor_liner";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ArmorLiner(IEventBus modEventBus, ModContainer ignoredModContainer) {
        ModComponents.register(modEventBus);
        ModItems.register(modEventBus);
        ModRecipeSerializers.register(modEventBus);
        modEventBus.addListener(this::addCreative);

        NeoForge.EVENT_BUS.addListener(ArmorLiningTooltipHandler::onItemTooltip);

        if (ModList.get().isLoaded(ToughAsNailsCompat.MOD_ID)) {
            ToughAsNailsCompat.init();
        }
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.LINER_SNIPS);
        }
    }
}
