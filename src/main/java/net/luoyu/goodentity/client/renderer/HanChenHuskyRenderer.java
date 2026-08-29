package net.luoyu.goodentity.client.renderer;

import net.luoyu.goodentity.GoodEntity;
import net.luoyu.goodentity.client.model.HanChenHuskyModel;
import net.luoyu.goodentity.entity.HanChenHuskyEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWolfModel;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class HanChenHuskyRenderer extends AdvancedHumanoidRenderer<HanChenHuskyEntity, HanChenHuskyModel> {
    public HanChenHuskyRenderer(EntityRendererProvider.Context context) {
        super(context, new HanChenHuskyModel(context.bakeLayer(HanChenHuskyModel.LAYER_LOCATION)),
                ArmorLatexMaleWolfModel.MODEL_SET, 0.5f);
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(new CustomEyesLayer<>(this,
                                            context.getModelSet(),
                                            CustomEyesLayer::scleraColor,
                                            CustomEyesLayer::irisColorLeft,
                                            CustomEyesLayer::irisColorRight,
                                            CustomEyesLayer::noRender, CustomEyesLayer::noRender));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull HanChenHuskyEntity entity) {
        return ResourceLocation.parse("goodentity:textures/entities/hanchen_husky.png");
    }

}


