package net.luoyu.goodentity.ability;

import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Toggle the glowing state of the entity.
 * Modeled after Foxyas's {@code ToggleGlowingState} in Changed-Addon-Rework.
 *
 * <p>For LuoYuWolfEntity, toggles the emissive glow layer via {@code GLOW_ON}
 * entity data (synced to client through {@code EntityDataAccessor}).</p>
 */
public class ToggleGlowingState extends AbstractAbility<ToggleGlowingStateInstance> {

    public ToggleGlowingState() {
        super(ToggleGlowingStateInstance::new);
    }

    @Override
    public Component getAbilityName(IAbstractChangedEntity entity) {
        return Component.translatable("ability.goodentity.toggle_glowing_state");
    }

    @Override
    public int getCoolDown(IAbstractChangedEntity entity) {
        return 0;
    }

    @Override
    public Collection<Component> getAbilityDescription(IAbstractChangedEntity entity) {
        return new ArrayList<>();
    }

    @Nullable
    @Override
    public Component getSelectedDisplayText(IAbstractChangedEntity entity) {
        return Component.translatable("ability.goodentity.toggle_glowing_state.have_interaction");
    }
}
