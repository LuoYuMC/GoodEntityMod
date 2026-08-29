package net.luoyu.goodentity.init;

import net.luoyu.goodentity.GoodEntity;
import net.luoyu.goodentity.entity.LuoYuWolfEntity;
import net.luoyu.goodentity.entity.HanChenHuskyEntity;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedAbilities;
import net.minecraft.world.entity.monster.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

/**
 * Transfur variant registrations for Good Entity.
 *
 * Pattern based on Foxyas's ChangedAddonTransfurVariants.
 * Each variant ties an entity type to its transfur recipe behavior.
 */
public class GoodEntityTransfurVariants {

    public static final DeferredRegister<TransfurVariant<?>> REGISTRY =
        net.ltxprogrammer.changed.init.ChangedRegistry.TRANSFUR_VARIANT.createDeferred(GoodEntity.MODID);

    // ============================================================
    // Variants
    // ============================================================

    /**
     * Form: LuoYu Wolf
     * Transfur mode: ABSORPTION (the transfur consumes the target)
     * Abilities: Basic night vision toggle
     *
     * Recipe namespace: goodentity:form_luoyu_wolf
     */
    public static final RegistryObject<TransfurVariant<LuoYuWolfEntity>> LUOYU_WOLF =
        register("form_luoyu_wolf",
                TransfurVariant.Builder.of(GoodEntityEntities.LUOYU_WOLF)
                        .breatheMode(TransfurVariant.BreatheMode.ANY)
                        .glide()
                        .scares(List.of(
                                AbstractSkeleton.class,
                                Creeper.class
                        ))
                        .nightVision()
                        .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION));

        public static final RegistryObject<TransfurVariant<HanChenHuskyEntity>> HANCHEN_HUSKY =
            register("form_hanchen_husky",
                    TransfurVariant.Builder.of(GoodEntityEntities.HANCHEN_HUSKY)
                        .replicating()
                        .breatheMode(TransfurVariant.BreatheMode.ANY)
                        .scares(List.of(
                                AbstractSkeleton.class,
                                Creeper.class
                        ))
                        .nightVision()
                        .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION));

    // ============================================================
    // Registration
    // ============================================================

    private static <T extends net.ltxprogrammer.changed.entity.ChangedEntity>
    RegistryObject<TransfurVariant<T>> register(String name,
            TransfurVariant.Builder<T> builder) {
        return REGISTRY.register(name, builder::build);
    }
}
