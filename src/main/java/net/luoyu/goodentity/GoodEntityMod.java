package net.luoyu.goodentity;

import net.luoyu.goodentity.entity.LuoYuWolfEntity;
import net.luoyu.goodentity.entity.HanChenHuskyEntity;
import net.luoyu.goodentity.init.GoodEntityEntities;
import net.luoyu.goodentity.init.GoodEntityItems;
import net.luoyu.goodentity.init.GoodEntityTransfurVariants;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main initialization class for Good Entity.
 * Registers all registries and handles common events.
 */
@Mod.EventBusSubscriber(modid = GoodEntity.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodEntityMod {

    private static final Logger LOGGER = LogManager.getLogger();
    public GoodEntityMod() {
        LOGGER.info("Good Entity initializing...");
    }

    // ===================== Common Setup =====================

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Good Entity common setup complete");
        });
    }

    // ===================== Attribute Creation =====================

    /**
     * Register attribute suppliers for all entities.
     * Called by Forge when entity attributes are being built.
     */
    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        // Register LuoYu Wolf attributes
        event.put(GoodEntityEntities.LUOYU_WOLF.get(),
                LuoYuWolfEntity.createAttributes().build());
                
        // Register HanChen Husky attributes
        event.put(GoodEntityEntities.HANCHEN_HUSKY.get(),
                HanChenHuskyEntity.createAttributes().build());
    }
}
