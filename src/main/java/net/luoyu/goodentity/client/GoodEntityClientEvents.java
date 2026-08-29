package net.luoyu.goodentity.client;

import net.luoyu.goodentity.GoodEntity;
import net.luoyu.goodentity.client.model.LuoYuWolfModel;
import net.luoyu.goodentity.client.renderer.LuoYuWolfRenderer;
import net.luoyu.goodentity.client.model.HanChenHuskyModel;
import net.luoyu.goodentity.client.renderer.HanChenHuskyRenderer;
import net.luoyu.goodentity.init.GoodEntityEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;

/**
 * Client-side events for Good Entity.
 * Only runs on the client (Dist.CLIENT).
 */
@Mod.EventBusSubscriber(modid = GoodEntity.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GoodEntityClientEvents {

    /**
     * Called during client setup.
     * Use for key bindings, screen handlers, etc.
     */
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Client-side initialization
            // e.g., register key bindings:
            // KeyMappingRegistry.register();
        });
    }

    /**
     * Register model layers for all entities.
     * Must be called before entities are rendered.
     */
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // Register the LuoYu Wolf model layer
        event.registerLayerDefinition(
                LuoYuWolfModel.LAYER_LOCATION,
                LuoYuWolfModel::createBodyLayer
        );
        // Register the HanChen Husky model layer
        event.registerLayerDefinition(
                HanChenHuskyModel.LAYER_LOCATION,
                HanChenHuskyModel::createBodyLayer
        );
    }

    /**
     * Register entity renderers.
     * Called when the game is setting up entity renderers.
     */
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Register the LuoYu Wolf renderer
        event.registerEntityRenderer(
                GoodEntityEntities.LUOYU_WOLF.get(),
                LuoYuWolfRenderer::new
        );

        // Register the HanChen Husky renderer
        event.registerEntityRenderer(
                GoodEntityEntities.HANCHEN_HUSKY.get(),
                HanChenHuskyRenderer::new
        );

        // Register spawn egg renderer (if using ForgeSpawnEggItem, it handles itself)
        // But if you have custom spawn eggs, register them here:
        // event.registerEntityRenderer(
        //         GoodEntityEntities.YOUR_ENTITY.get(),
        //         YourEntityRenderer::new
        // );
    }
}
