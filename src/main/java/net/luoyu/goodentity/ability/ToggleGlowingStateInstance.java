package net.luoyu.goodentity.ability;

import net.luoyu.goodentity.entity.LuoYuWolfEntity;
import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.AbstractAbilityInstance;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.network.chat.Component;

/**
 * Instance of {@link ToggleGlowingState} for Good Entity mods.
 *
 * <p>For {@link LuoYuWolfEntity}: toggles the emissive glow layer on/off.</p>
 */
public class ToggleGlowingStateInstance extends AbstractAbilityInstance {

    public ToggleGlowingStateInstance(AbstractAbility<?> ability, IAbstractChangedEntity entity) {
        super(ability, entity);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public AbstractAbility.UseType getUseType() {
        return AbstractAbility.UseType.INSTANT;
    }

    @Override
    public boolean canKeepUsing() {
        return true;
    }

    @Override
    public void startUsing() {
        ChangedEntity changedEntity = entity.getChangedEntity();
        if (changedEntity instanceof LuoYuWolfEntity luoyuWolf) {
            boolean value = !luoyuWolf.isGlowOn();
            luoyuWolf.setGlowOn(value);
            entity.displayClientMessage(
                Component.translatable("ability.goodentity.toggle_glowing_state.have_interaction.glow_layer.action", value),
                true);
        }
    }

    @Override
    public void tick() {
        // No per-tick behavior
    }

    @Override
    public void stopUsing() {
        // No cleanup needed
    }

    public void onSelected() {
        Component text = ability.getSelectedDisplayText(this.entity);
        if (entity.getEntity() instanceof net.minecraft.world.entity.player.Player player && text != null) {
            player.displayClientMessage(text, true);
        }
    }
}
