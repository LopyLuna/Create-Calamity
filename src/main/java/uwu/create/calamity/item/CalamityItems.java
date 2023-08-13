package uwu.create.calamity.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import uwu.create.calamity.Calamity;
import uwu.create.calamity.item.custom.TestItem;

public class CalamityItems {
    public static final Item TEST_ITEM = registerItem("test_item",
            new TestItem(new FabricItemSettings().group(CalamityItemGroup.CALAMITY).maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Calamity.MODID, name), item);
    }

    public static void registerItems() {
        Calamity.devLogger("Registering " + Calamity.MODID + " Mod items");
    }
}
