package net.luoyu.goodentity.client.renderer;

import net.luoyu.goodentity.GoodEntity;
import net.luoyu.goodentity.client.model.LuoYuWolfModel;
import net.luoyu.goodentity.client.renderer.layers.LuoYuWolfEmissiveBodyLayer;
import net.luoyu.goodentity.entity.LuoYuWolfEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWolfModel;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LuoYuWolfRenderer extends AdvancedHumanoidRenderer<LuoYuWolfEntity, LuoYuWolfModel> {
    public LuoYuWolfRenderer(EntityRendererProvider.Context context) {
        super(context, new LuoYuWolfModel(context.bakeLayer(LuoYuWolfModel.LAYER_LOCATION)),
                ArmorLatexMaleWolfModel.MODEL_SET, 0.5f);
        this.addLayer(new LuoYuWolfEmissiveBodyLayer<>(this, GoodEntity.textureLoc("textures/entities/luoyu_wolf/LuoYu_glow")));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(new CustomEyesLayer<>(this,
                                            context.getModelSet(),
                                            CustomEyesLayer::scleraColor,
                                            CustomEyesLayer::glowingIrisColorLeft,
                                            CustomEyesLayer::glowingIrisColorRight,
                                            CustomEyesLayer::noRender, CustomEyesLayer::noRender));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull LuoYuWolfEntity entity) {
        return ResourceLocation.parse("goodentity:textures/entities/luoyu_wolf/LuoYu.png");
    }

}


