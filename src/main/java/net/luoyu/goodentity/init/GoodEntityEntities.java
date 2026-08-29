package net.luoyu.goodentity.init;

import net.luoyu.goodentity.GoodEntity;
import net.luoyu.goodentity.entity.LuoYuWolfEntity;
import net.luoyu.goodentity.entity.HanChenHuskyEntity;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.*;
import net.ltxprogrammer.changed.util.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Entity type registrations for Good Entity.
 *
 * Pattern based on Foxyas's ChangedAddonEntities.
 */
public class GoodEntityEntities {

    public static final DeferredRegister<EntityType<?>> REGISTRY =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GoodEntity.MODID);
    private static <T extends ChangedEntity>
    RegistryObject<EntityType<T>> registerChangedEntity(String name,
            EntityType.Builder<T> builder) {
        return REGISTRY.register(name, () -> builder.build(name));
    }
    
    public static final RegistryObject<EntityType<LuoYuWolfEntity>> LUOYU_WOLF = registerChangedEntity("luoyu_wolf",
            EntityType.Builder.<LuoYuWolfEntity>of(LuoYuWolfEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .fireImmune()
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<HanChenHuskyEntity>> HANCHEN_HUSKY = registerChangedEntity("hanchen_husky",
            EntityType.Builder.<HanChenHuskyEntity>of(HanChenHuskyEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .fireImmune()
                    .sized(0.7f, 1.93f));

    private static <T extends net.minecraft.world.entity.Entity>
    RegistryObject<EntityType<T>> registerEntity(String name,
            EntityType.Builder<T> builder) {
        return REGISTRY.register(name, () -> builder.build(name));
    }
}
