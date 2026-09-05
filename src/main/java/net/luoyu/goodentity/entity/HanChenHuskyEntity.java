package net.luoyu.goodentity.entity;

import net.luoyu.goodentity.GoodEntity;
import net.luoyu.goodentity.init.GoodEntityEntities;
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.entity.latex.*;
import net.ltxprogrammer.changed.init.ChangedAttributes;
import net.ltxprogrammer.changed.init.ChangedDamageSources;
import net.ltxprogrammer.changed.init.ChangedTags;
import net.ltxprogrammer.changed.init.ChangedLatexTypes;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nullable;
import java.util.List;

import static net.ltxprogrammer.changed.entity.HairStyle.BALD;


public class HanChenHuskyEntity extends ChangedEntity {

    public HanChenHuskyEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }

    // ===================== Attributes =====================

    public static AttributeSupplier.Builder createAttributes() {
        return ChangedEntity.createLatexAttributes()
            .add(ChangedAttributes.SPRINT_SPEED.get(), 1.5D)
            .add(ChangedAttributes.SNEAK_SPEED.get(), 1.5D)
            .add(ChangedAttributes.AIR_CAPACITY.get(), 15.0)
            .add(ChangedAttributes.JUMP_STRENGTH.get(), 1.5D)
            .add(ChangedAttributes.FALL_RESISTANCE.get(), 5.0D)
            .add(ChangedAttributes.TRANSFUR_DAMAGE.get(), 7)
            .add(Attributes.MOVEMENT_SPEED, 1.5)
            .add(Attributes.MAX_HEALTH, 40)
            .add(Attributes.ARMOR, 0)
            .add(Attributes.ATTACK_DAMAGE, 5)
            .add(Attributes.FOLLOW_RANGE, 48)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0.6);
    }

    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);

        attributes.getInstance(ChangedAttributes.TRANSFUR_DAMAGE.get()).setBaseValue(7);
        attributes.getInstance(ChangedAttributes.SPRINT_SPEED.get()).setBaseValue(1.5D);
        attributes.getInstance(ChangedAttributes.SNEAK_SPEED.get()).setBaseValue(1.5D);
        attributes.getInstance(ChangedAttributes.AIR_CAPACITY.get()).setBaseValue(15.0);
        attributes.getInstance(ChangedAttributes.JUMP_STRENGTH.get()).setBaseValue(1.5);
        attributes.getInstance(ChangedAttributes.FALL_RESISTANCE.get()).setBaseValue(5.0);
        attributes.getInstance(Attributes.MAX_HEALTH).setBaseValue(40);
        attributes.getInstance(Attributes.FOLLOW_RANGE).setBaseValue(48.0f);
        attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(1.5);
        attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.5f);
        attributes.getInstance(Attributes.ATTACK_DAMAGE).setBaseValue(5.0f);
        attributes.getInstance(Attributes.ARMOR).setBaseValue(0);
        attributes.getInstance(Attributes.ARMOR_TOUGHNESS).setBaseValue(5);
        attributes.getInstance(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0.6);
    }
    
    // ===================== Gender =====================

    
    public Gender getGender() {
        return Gender.MALE;
    }

    // ===================== Hair =====================

    @Override
    public Color3 getHairColor(int i) {
        return Color3.getColor("#2b2b2b");
    }

    @Override
    public HairStyle getDefaultHairStyle() {
        return BALD.get();
    }

    @Nullable
    @Override
    public List<HairStyle> getValidHairStyles() {
        return HairStyle.Collection.MALE.getStyles();
    }

    // ===================== Colors =====================

    
    @Override
    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#2b2b2b");
    }

    // ===================== Freeze =====================

    @Override
    public int getTicksRequiredToFreeze() {
        return 1000;
    }

    // ===================== Target =====================

    @Override
    protected boolean targetSelectorTest(LivingEntity livingEntity) {
        return livingEntity instanceof Player || livingEntity instanceof ServerPlayer || livingEntity.getType().is(ChangedTags.EntityTypes.HUMANOIDS);
    }

    // ===================== Packet =====================

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    // ===================== Goals =====================

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    // ===================== Mob Type & Damage =====================

    @Override
    public @NotNull MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public @NotNull SoundEvent getHurtSound(@NotNull DamageSource ds) {
        return SoundEvents.GENERIC_HURT;
    }

    @Override
    public @NotNull SoundEvent getDeathSound() {
        return SoundEvents.GENERIC_DEATH;
    }

    @Override
    public boolean removeWhenFarAway(double distance) {
        return false;
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
}
