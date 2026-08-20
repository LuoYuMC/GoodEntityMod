package net.luoyu.goodentity.ability;

import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.ability.SimpleAbility;
import net.ltxprogrammer.changed.ability.SimpleAbilityInstance;
import net.minecraft.world.entity.player.Player;

/**
 * Ability registry for Good Entity.
 * Based on the Changed mod's ability system and Foxyas's addon pattern.
 *
 * To create a new ability:
 * 1. Create a class extending SimpleAbility (for simple abilities)
 *    or AbstractAbility<YourInstance> ( for complex abilities)
 * 2. Register it here
 * 3. Add it to a TransfurVariant's abilities list
 */
public class GoodEntityAbilities {

    // Example ability registration (replace with your actual abilities)
    // public static final RegistryObject<SimpleAbility> EXAMPLE_ABILITY =
    //         GoodEntityRegistries.ABILITIES.register("example_ability", ExampleAbility::new);

    /**
     * Register all abilities.
     * Call this from GoodEntity.java or your initialization class.
     */
    public static void register(net.minecraftforge.eventbus.api.IEventBus bus) {
        // GoodEntityRegistries.ABILITIES.register(bus);
    }

    /**
     * Base class for simple abilities.
     * Implement the required methods: canUse(), startUsing(), tick(), stopUsing(), onRemove()
     */
    public static abstract class BaseAbility extends SimpleAbility {

        public BaseAbility() {
            super();
        }

        /**
         * Check if the ability can be used.
         */
        public abstract boolean canUse(IAbstractChangedEntity entity);

        /**
         * Start using the ability.
         */
        public abstract void startUsing(IAbstractChangedEntity entity);

        /**
         * Tick while using the ability.
         */
        public abstract void tick(IAbstractChangedEntity entity);

        /**
         * Stop using the ability.
         */
        public abstract void stopUsing(IAbstractChangedEntity entity);

        /**
         * Called when the ability is removed.
         */
        public abstract void onRemove(IAbstractChangedEntity entity);
    }

    /**
     * Base class for complex abilities (with custom instance).
     */
    public static abstract class ComplexAbility extends AbstractAbility<ComplexAbilityInstance> {

        public ComplexAbility() {
            super(ComplexAbilityInstance::new);
        }
    }
}
