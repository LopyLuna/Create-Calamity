package com.calamityteam.calamity;

import com.calamityteam.calamity.registry.worldgen.CLFeatures;
import com.calamityteam.calamity.registry.*;

public class ModSetup {
	public static void register() {
		/*CLTrackMaterials.register();
		CLBogeyStyles.register();
		CLItems.register();
		CLBlockEntities.register();*/
		CLBlocks.register();
		/*CLContainerTypes.register();
		CLEntities.register();
		CLSounds.register();*/
		CLTags.register();
		CLAdvancements.register();
		/*CLEdgePointTypes.register();
		CLSchedule.register();
		CLDataFixers.register();
		CLExtraRegistration.register();
		CasingCollisionUtils.register();*/
	}

	public static void registerPostRegistrate() {
		CLFeatures.register();
	}
}