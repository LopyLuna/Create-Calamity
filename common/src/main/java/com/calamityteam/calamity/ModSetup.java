package com.calamityteam.calamity;

import com.calamityteam.calamity.registry.worldgen.CLFeatures;
import com.calamityteam.calamity.registry.*;

public class ModSetup {
	public static void register() {
		/*CLTrackMaterials.register();
		CLBogeyStyles.register();
		CLItems.register();
		CLBlockEntities.register();*/
		CLSounds.register();
		CLBlocks.register();
		PlushieRegistry.register();
		/*CLContainerTypes.register();
		CLEntities.register();*/
		CLTags.register();
		/*CLEdgePointTypes.register();
		CLSchedule.register();
		CLDataFixers.register();
		CLExtraRegistration.register();
		CasingCollisionUtils.register();*/
	}

	public static void registerPostRegistrate() {
		//FIXME: Forge ore generation breaks here!
		//CLFeatures.register();
	}
}