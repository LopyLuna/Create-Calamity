package uwu.create.calamity;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uwu.create.calamity.block.CalamityBlockEntities;
import uwu.create.calamity.block.CalamityBlocks;
import uwu.create.calamity.item.CalamityItems;

public class Calamity implements ModInitializer {
    public static final String MODID = "create-calamity";
	private static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        CalamityItems.registerItems();
        CalamityBlocks.registerBlocks();
        CalamityBlockEntities.registerBlockEntities();

        devLogger("Loaded " + MODID + " Mod");
    }

    /**
     * Helper method to clean up user console <br><br>
     * <i>This method will only print lines if the Minecraft
     * Instance has been launched in a developer environment!</i>
     *
     * @param input String to print in the LOGGER
     */
    public static void devLogger(String input) {
        if (!FabricLoader.getInstance().isDevelopmentEnvironment()) return;
        LOGGER.info("Dev - [" + input + "]");
    }
}