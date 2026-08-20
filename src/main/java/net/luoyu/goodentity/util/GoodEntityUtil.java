package net.luoyu.goodentity.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * Utility class for common operations in Good Entity.
 * Based on patterns from the Changed mod's util package.
 */
public class GoodEntityUtil {

    /**
     * Creates an Ingredient from an ItemStack.
     */
    public static Ingredient ofStack(ItemStack stack) {
        return Ingredient.of(stack);
    }

    /**
     * Creates an Ingredient from a ResourceLocation (item path).
     */
    public static Ingredient ofItem(ResourceLocation item) {
        return Ingredient.of(net.minecraftforge.registries.ForgeRegistries.ITEMS.getValue(item));
    }

    /**
     * Checks if a mod is present on the classpath.
     */
    public static boolean isModPresent(String modId) {
        return net.minecraftforge.fml.ModList.get().isLoaded(modId);
    }

    /**
     * Safely gets a registry object, returning null if not found.
     */
    public static <T> T getRegistryObject(net.minecraft.core.Registry<T> registry, ResourceLocation id) {
        return registry.get(id);
    }
}
