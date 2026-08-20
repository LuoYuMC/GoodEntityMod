package net.luoyu.goodentity.entity;

import net.luoyu.goodentity.GoodEntity;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.HairStyle;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.ltxprogrammer.changed.entity.HairStyle.BALD;

/**
 * Base entity for LuoYu's addon entities.
 * Demonstrates the pattern used by Experiment009Entity in the reference addon.
 *
 * To create a new entity:
 * 1. Extend this class (or ChangedEntity directly)
 * 2. Register it in LuoYuRegistries.ENTITY_TYPES
 * 3. Register attributes in LuoYuEntityEvents
 * 4. Create a TransfurVariant in GoodEntityTransfurVariants
 */
public abstract class GoodEntityBaseEntity extends ChangedEntity {

    // Define entity data accessors here (e.g., phase flags, custom state)
    // protected static final EntityDataAccessor<Boolean> SOME_STATE =
    //         SynchedEntityData.defineId(SomeEntity.class, EntityDataSerializers.BOOLEAN);

    public GoodEntityBaseEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    /**
     * Create attribute supplier for this entity.
     * Override in subclass and call super.createAttributes().
     */
    public static AttributeSupplier.Builder createBaseAttributes() {
        return ChangedEntity.createLatexAttributes()
                .add(Attributes.MAX_HEALTH, 40.0)
                .add(Attributes.MOVEMENT_SPEED, 1.0)
                .add(Attributes.ATTACK_DAMAGE, 4.0)
                .add(Attributes.FOLLOW_RANGE, 32.0);
    }

    /**
     * Override to customize attribute values after base registration.
     * Called automatically when the entity is constructed.
     */
    protected void customizeAttributes(AttributeMap attributes) {
        // Override in subclass
    }

    // ==================== Hair Style ====================

    /**
     * Default hair style for this entity.
     * Override in subclass.
     */
    public HairStyle getDefaultHairStyle() {
        return BALD.get();
    }

    /**
     * Valid hair styles for this entity.
     * Override in subclass.
     */
    @Nullable
    public List<HairStyle> getValidHairStyles() {
        return HairStyle.Collection.MALE.getStyles();
    }

    // ==================== Transfur ====================

    /**
     * The transfur mode for this entity.
     * Override in subclass. Return TransfurMode.NONE for standalone entities.
     */
    public TransfurMode getTransfurMode() {
        return TransfurMode.NONE;
    }

    // ==================== Damage & AI ====================

    @Override
    protected boolean targetSelectorTest(LivingEntity target) {
        return target instanceof Player;
    }

    @Override
    public boolean removeWhenFarAway(double distance) {
        return false; 
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    // ==================== Save/Load ====================

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        // Save custom state here
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        // Load custom state here
    }

    @Override
    public CompoundTag savePlayerVariantData() {
        CompoundTag tag = super.savePlayerVariantData();
        // Save variant-specific data
        return tag;
    }

    @Override
    public void readPlayerVariantData(CompoundTag tag) {
        super.readPlayerVariantData(tag);
        // Load variant-specific data
    }
}
