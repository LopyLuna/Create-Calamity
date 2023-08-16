package com.calamityteam.calamity.multiloader.forge;

import com.calamityteam.calamity.multiloader.Env;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class EnvImpl {
	public static Env getCurrent() {
		return FMLEnvironment.dist == Dist.CLIENT ? Env.CLIENT : Env.SERVER;
	}
}
