package net.luoyu.goodentity.init;

import net.luoyu.goodentity.GoodEntity;
import net.luoyu.goodentity.entity.LuoYuWolfEntity;
import net.luoyu.goodentity.entity.HanChenHuskyEntity;
import net.luoyu.goodentity.util.GoodEntityUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Item registrations for Good Entity.
 *
 * Based on Foxyas's ChangedAddonItems pattern.
 */
public class GoodEntityItems {

    public static final DeferredRegister<Item> REGISTRY =
            DeferredRegister.create(ForgeRegistries.ITEMS, GoodEntity.MODID);

    // ============================================================
    // Spawn Eggs
    // ============================================================

    /**
     * Spawn egg for the LuoYu Wolf entity.
     * Colors: brown body (#8B4513), dark brown pattern (#5D3A1A)
     */
    public static final RegistryObject<Item> LUOYU_WOLF_SPAWN_EGG =
            REGISTRY.register("luoyu_wolf_spawn_egg", () ->
                    new net.minecraftforge.common.ForgeSpawnEggItem(
                            GoodEntityEntities.LUOYU_WOLF,
                            0x0E3A96,   
                            0x45C3EE,   
                            new Item.Properties()
                    ));

        public static final RegistryObject<Item> HANCHEN_HUSKY_SPAWN_EGG =
            REGISTRY.register("hanchen_husky_spawn_egg", () ->
                    new net.minecraftforge.common.ForgeSpawnEggItem(
                            GoodEntityEntities.HANCHEN_HUSKY,
                            0x2B2B2B,   
                            0x878787,   
                            new Item.Properties()
                    ));

    // ============================================================
    // Example DNA / Latex items (optional, for future use)
    // ============================================================

    

    // ============================================================
    // Registration
    // ============================================================

    public static void register(net.minecraftforge.eventbus.api.IEventBus bus) {
        REGISTRY.register(bus);
    }
}
