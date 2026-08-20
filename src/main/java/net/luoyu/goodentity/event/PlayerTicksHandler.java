package net.luoyu.goodentity.event;

import net.luoyu.goodentity.GoodEntity;
import net.luoyu.goodentity.init.GoodEntityTransfurVariants;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoodEntity.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerTicksHandler {
    
    @SubscribeEvent
    public static void playerFireParticle(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }
        Player player = event.player;
        boolean isFlying = player.getAbilities().flying;
        if (!player.level().isClientSide && isFlying) {
            onPlayerFlying(player);
        }
    }

    

    private static void onPlayerFlying(Player player) {
        TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
        if (variant == null) {
            return;
        }

        if (variant.getParent() == GoodEntityTransfurVariants.LUOYU_WOLF.get()) {
            ServerLevel serverLevel = (ServerLevel) player.level();

            double particleAngle = (player.tickCount % 24) / 12.0D * Math.PI;
            double x = player.getX();
            double y = player.getY();
            double z = player.getZ();
            double dx = Math.cos(particleAngle) * 0.8;
            double dz = Math.sin(particleAngle) * 0.8;
            serverLevel.sendParticles(ParticleTypes.FLAME, x+dx, y, z+dz, 1, 0.0D, 0.0D, 0.0D, 0.01D);
            serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x-dx, y, z-dz, 1, 0.0D, 0.0D, 0.0D, 0.01D);
          }
    }
}
