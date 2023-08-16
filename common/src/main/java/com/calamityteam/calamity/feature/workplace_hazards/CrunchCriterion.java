package com.calamityteam.calamity.feature.workplace_hazards;

import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import com.calamityteam.calamity.CreateCalamity;
import com.google.gson.JsonObject;

public class CrunchCriterion extends SimpleCriterionTrigger<CrunchCriterion.TriggerInstance> {
	public CrunchCriterion() {}
	@Override
	protected TriggerInstance createInstance(JsonObject json, EntityPredicate.Composite player, DeserializationContext context) {
		return new TriggerInstance(player );
	}

	public void trigger(ServerPlayer player) {
		trigger(player, condition -> {
			return true;
		});
	}

	public final static ResourceLocation ID = CreateCalamity.asResource("crunched");
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
