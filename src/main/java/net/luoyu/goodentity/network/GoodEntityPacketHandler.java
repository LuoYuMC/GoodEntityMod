package net.luoyu.goodentity.network;

import net.luoyu.goodentity.GoodEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

/**
 * Network handler for Good Entity.
 * Based on the Changed mod's packet pattern.
 *
 * To add a new packet:
 * 1. Create a packet class implementing IMessage
 * 2. Register it with a unique ID in registerMessages()
 * 3. Send/receive using GoodEntityPacketHandler.sendToServer() or sendToPlayer()
 */
public class GoodEntityPacketHandler {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            GoodEntity.resourceLoc("network"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static int messageID = 0;

    /**
     * Register all packet types here.
     */
    public static void registerMessages() {
        // Example:
        // CHANNEL.register(messageClass, decoder, encoder, handler, NetworkDirection.PLAY_TO_SERVER);
    }

    /**
     * Sends a message to the server.
     */
    public static <MSG> void sendToServer(MSG message) {
        CHANNEL.sendToServer(message);
    }

    /**
     * Sends a message to a specific player.
     */
    public static <MSG> void sendToPlayer(MSG message, net.minecraft.server.level.ServerPlayer player) {
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    /**
     * Sends a message to all players in a dimension.
     */
    public static <MSG> void sendToAll(MSG message) {
        CHANNEL.send(PacketDistributor.ALL.noArg(), message);
    }

    /**
     * Decodes a message from a buffer.
     */
    public static <MSG> void decode(FriendlyByteBuf buf, MSG message) {
        // Implement decoding logic
    }

    /**
     * Encodes a message to a buffer.
     */
    public static <MSG> void encode(MSG message, FriendlyByteBuf buf) {
        // Implement encoding logic
    }
}
