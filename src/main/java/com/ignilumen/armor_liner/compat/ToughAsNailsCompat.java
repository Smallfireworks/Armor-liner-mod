package com.ignilumen.armor_liner.compat;

import com.ignilumen.armor_liner.ArmorLiner;
import com.ignilumen.armor_liner.util.ArmorLiningUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.minecraft.world.entity.player.Player;

public final class ToughAsNailsCompat {
    public static final String MOD_ID = "toughasnails";

    private static boolean initialized;

    private ToughAsNailsCompat() {}

    public static void init() {
        if (initialized) {
            return;
        }
        initialized = true;

        try {
            Class<?> modifierInterface = Class.forName("toughasnails.api.temperature.IPlayerTemperatureModifier");
            Class<?> helperClass = Class.forName("toughasnails.api.temperature.TemperatureHelper");
            Class<?> temperatureLevelClass = Class.forName("toughasnails.api.temperature.TemperatureLevel");
            Method registerMethod = helperClass.getMethod("registerPlayerTemperatureModifier", modifierInterface);
            Method incrementMethod = temperatureLevelClass.getMethod("increment", int.class);

            InvocationHandler handler = (proxy, method, args) -> {
                if ("modify".equals(method.getName())
                        && args != null
                        && args.length == 2
                        && args[0] instanceof Player player) {
                    int modifier = ArmorLiningUtil.getNetTemperatureModifier(player);
                    return modifier == 0 ? args[1] : incrementMethod.invoke(args[1], modifier);
                }

                if (method.getDeclaringClass() == Object.class) {
                    return handleObjectMethod(proxy, method, args);
                }

                throw new UnsupportedOperationException("Unsupported Tough As Nails callback: " + method.getName());
            };

            Object proxy = Proxy.newProxyInstance(
                    modifierInterface.getClassLoader(),
                    new Class<?>[] { modifierInterface },
                    handler
            );
            registerMethod.invoke(null, proxy);

            ArmorLiner.LOGGER.info("Registered Tough As Nails temperature compatibility");
        } catch (ReflectiveOperationException | RuntimeException exception) {
            ArmorLiner.LOGGER.error("Failed to initialize Tough As Nails compatibility", exception);
        }
    }

    private static Object handleObjectMethod(Object proxy, Method method, Object[] args) {
        return switch (method.getName()) {
            case "toString" -> "ArmorLinerToughAsNailsCompat";
            case "hashCode" -> System.identityHashCode(proxy);
            case "equals" -> args != null && args.length == 1 && proxy == args[0];
            default -> null;
        };
    }
}
