package com.calamityteam.calamity;

import com.calamityteam.calamity.base.data.lang.CLCustomLang;
import com.calamityteam.calamity.infrastructure.events.CommonEvents;
import com.calamityteam.calamity.registry.*;

public class ModSetup {
	public static void register() {
		/*CLTrackMaterials.register();
		CLBogeyStyles.register();*/
		CLItems.register();
		//CLBlockEntities.register();
		CLSounds.register();
		CLBlocks.register();
		CLPlushies.register();
		CLCustomLang.register();
		CommonEvents.register();
		/*CLContainerTypes.register();
		CLEntities.register();*/
		CLTags.register();
		CLAdvancements.register();
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