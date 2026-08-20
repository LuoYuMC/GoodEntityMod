package net.luoyu.goodentity.ability;

import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.AbstractAbilityInstance;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.minecraft.nbt.CompoundTag;

/**
 * Custom ability instance for complex abilities.
 * Based on SimpleAbilityInstance from the Changed mod.
 */
public class ComplexAbilityInstance extends AbstractAbilityInstance {

    public ComplexAbilityInstance(AbstractAbility<?> ability, IAbstractChangedEntity entity) {
        super(ability, entity);
    }

    @Override
    public boolean canUse() {
        return ability.canUse(entity);
    }

    @Override
    public boolean canKeepUsing() {
        return ability.canKeepUsing(entity);
    }

    @Override
    public void startUsing() {
        ability.startUsing(entity);
    }

    @Override
    public void tick() {
        ability.tick(entity);
    }

    @Override
    public void stopUsing() {
        ability.stopUsing(entity);
    }

    @Override
    public void onRemove() {
        ability.onRemove(entity);
    }

    @Override
    public void saveData(CompoundTag tag) {
        ability.saveData(tag, entity);
    }

    @Override
    public void readData(CompoundTag tag) {
        ability.readData(tag, entity);
    }
}
