package net.luoyu.goodentity;

import net.luoyu.goodentity.init.GoodEntityEntities;
import net.luoyu.goodentity.init.GoodEntityItems;
import net.luoyu.goodentity.init.GoodEntityTransfurVariants;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GoodEntity.MODID)
public class GoodEntity {

    public static final String MODID = "goodentity";
    public static final Logger LOGGER = LogManager.getLogger();

    public GoodEntity(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register all DeferredRegisters
        GoodEntityEntities.REGISTRY.register(modEventBus);
        GoodEntityItems.REGISTRY.register(modEventBus);
        GoodEntityTransfurVariants.REGISTRY.register(modEventBus);

        LOGGER.info("Good Entity ({} v{}) loaded successfully!", MODID, GoodEntity.class.getPackage().getImplementationVersion());
    }

    /**
     * Creates a ModelLayerLocation for this mod.
     * Use in client model classes.
     */
    public static ModelLayerLocation layerLocation(String name, String layer) {
        return new ModelLayerLocation(resourceLoc(name), layer);
    }
    

    /**
     * Creates a ResourceLocation using this mod's namespace.
     */
    public static ResourceLocation resourceLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
    
    public static ResourceLocation textureLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path + ".png");
    }
}
