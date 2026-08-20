package net.luoyu.goodentity.client.renderer;

import net.luoyu.goodentity.GoodEntity;
import net.luoyu.goodentity.entity.GoodEntityBaseEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

/**
 * Base renderer for LuoYu's entities.
 * Extend this class and override getTextureLocation() for each entity.
 *
 * Example usage:
 * <pre>
 * public class MyEntityRenderer extends GoodEntityEntityRenderer<MyEntity> {
 *     public MyEntityRenderer(EntityRendererProvider.Context context) {
 *         super(context, new MyEntityModel(context.bakeLayer(GoodEntityModelLayers.MY_ENTITY)));
 *     }
 *
 *     @Override
 *     protected @NotNull ResourceLocation getTextureLocation(@NotNull MyEntity entity) {
 *         return GoodEntity.resourceLoc("textures/entities/my_entity.png");
 *     }
 * }
 * </pre>
 */
public abstract class GoodEntityEntityRenderer<T extends GoodEntityBaseEntity> extends EntityRenderer<T> {

    protected GoodEntityEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    /**
     * Get the texture location for this entity.
     * Override in subclass.
     */
    @Override
    public abstract @org.jetbrains.annotations.NotNull ResourceLocation getTextureLocation(@org.jetbrains.annotations.NotNull T entity);
}
