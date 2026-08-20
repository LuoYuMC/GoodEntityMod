package net.luoyu.goodentity.client.model;

import net.luoyu.goodentity.GoodEntity;
import net.luoyu.goodentity.entity.GoodEntityBaseEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;

/**
 * Model layer location registry for Good Entity.
 * Create one instance per entity model.
 *
 * Example usage in your model class:
 * <pre>
 * public class MyEntityModel extends AdvancedHumanoidModel<MyEntity> {
 *     public static final ModelLayerLocation LAYER_LOCATION =
 *         MyEntityModel.registerLayer("my_entity", "main");
 *
 *     public MyEntityModel(ModelPart root) {
 *         super(root);
 *         // ... setup model parts ...
 *     }
 * }
 * </pre>
 */
public class GoodEntityModelLayers {

    /**
     * Register a new model layer location.
     * Call this from your model class as a static field.
     */
    public static ModelLayerLocation register(String name, String layer) {
        return new ModelLayerLocation(GoodEntity.resourceLoc(name), layer);
    }

    // Example layer locations (replace with your actual entities)
    // public static final ModelLayerLocation MY_ENTITY =
    //         register("my_entity", "main");
}
