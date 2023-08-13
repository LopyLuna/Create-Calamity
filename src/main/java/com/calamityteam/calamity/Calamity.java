package com.calamityteam.calamity;

import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Calamity.ID)
public class Calamity {
	public static final String ID = "createcalamity";
	public static final String NAME = "Create Calamity";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	public Calamity() {
		LOGGER.info("hehe boi");
	}
}
