package com.calamityteam.calamity.multiloader.fabric;

import java.util.List;
import java.util.function.Function;

import com.calamityteam.calamity.multiloader.C2SPacket;
import com.calamityteam.calamity.multiloader.PacketSet;

import com.calamityteam.calamity.multiloader.PlayerSelection;

import com.calamityteam.calamity.multiloader.S2CPacket;

import it.unimi.dsi.fastutil.objects.Object2IntMap;

import org.jetbrains.annotations.ApiStatus.Internal;

import com.simibubi.create.AllPackets;
import com.simibubi.create.foundation.networking.SimplePacketBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class PacketSetImpl extends PacketSet {
	protected PacketSetImpl(String id, int version,
							List<Function<FriendlyByteBuf, S2CPacket>> s2cPackets,
							Object2IntMap<Class<? extends S2CPacket>> s2cTypes,
							List<Function<FriendlyByteBuf, C2SPacket>> c2sPackets,
							Object2IntMap<Class<? extends C2SPacket>> c2sTypes) {
		super(id, version, s2cPackets, s2cTypes, c2sPackets, c2sTypes);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void registerS2CListener() {
		ClientPlayNetworking.registerGlobalReceiver(s2cPacket, this::handleClientPacket);
	}

	@Environment(EnvType.CLIENT)
	private void handleClientPacket(Minecraft mc, ClientPacketListener listener,
									FriendlyByteBuf buf, PacketSender sender) {
		handleS2CPacket(mc, buf);
	}

	@Override
	public void registerC2SListener() {
		ServerPlayNetworking.registerGlobalReceiver(c2sPacket, this::handleServerPacket);
	}

	private void handleServerPacket(MinecraftServer server, ServerPlayer player,
									ServerGamePacketListenerImpl listener, FriendlyByteBuf buf,
									PacketSender sender) {
		handleC2SPacket(player, buf);
	}

	@Override
	@Environment(EnvType.CLIENT)
	protected void doSendC2S(FriendlyByteBuf buf) {
		ClientPlayNetworking.send(c2sPacket, buf);
	}

	@Override
	public void send(SimplePacketBase packet) {
		AllPackets.getChannel().sendToServer(packet);
	}

	@Override
	public void sendTo(ServerPlayer player, SimplePacketBase packet) {
		AllPackets.getChannel().sendToClient(packet, player);
	}

	@Override
	public void sendTo(PlayerSelection selection, SimplePacketBase packet) {
		AllPackets.getChannel().sendToClients(packet, ((PlayerSelectionImpl) selection).players);
	}

	@Internal
	public static PacketSet create(String id, int version,
								   List<Function<FriendlyByteBuf, S2CPacket>> s2cPackets,
								   Object2IntMap<Class<? extends S2CPacket>> s2cTypes,
								   List<Function<FriendlyByteBuf, C2SPacket>> c2sPackets,
								   Object2IntMap<Class<? extends C2SPacket>> c2sTypes) {
		return new PacketSetImpl(id, version, s2cPackets, s2cTypes, c2sPackets, c2sTypes);
	}
}
