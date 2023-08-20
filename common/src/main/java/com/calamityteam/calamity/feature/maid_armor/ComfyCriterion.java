package com.calamityteam.calamity.feature.maid_armor;

import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import com.calamityteam.calamity.Calamity;
import com.google.gson.JsonObject;

public class ComfyCriterion extends SimpleCriterionTrigger<ComfyCriterion.TriggerInstance> {
	public ComfyCriterion() {}
	@Override
	protected TriggerInstance createInstance(JsonObject json, EntityPredicate.Composite player, DeserializationContext context) {
		return new TriggerInstance(player );
	}

	public void trigger(ServerPlayer player) {
		trigger(player, condition -> {
			return true;
		});
	}

	public final static ResourceLocation ID = Calamity.asResource("comfy_100");
	@Override
	public ResourceLocation getId() {
		return ID;
	}

	public class TriggerInstance extends AbstractCriterionTriggerInstance {
		public TriggerInstance(EntityPredicate.Composite player) {
			super(ID, player);
		}
	}
}
