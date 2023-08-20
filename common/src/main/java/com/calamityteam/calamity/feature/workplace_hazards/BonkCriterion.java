package com.calamityteam.calamity.feature.workplace_hazards;

import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import com.calamityteam.calamity.Calamity;
import com.google.gson.JsonObject;

public class BonkCriterion extends SimpleCriterionTrigger<BonkCriterion.TriggerInstance> {
	public BonkCriterion() {}
	@Override
	protected TriggerInstance createInstance(JsonObject json, EntityPredicate.Composite player, DeserializationContext context) {
		return new TriggerInstance(player );
	}

	public void trigger(ServerPlayer player) {
		trigger(player, condition -> {
			return true;
		});
	}

	public final static ResourceLocation ID = Calamity.asResource("bonked");
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
