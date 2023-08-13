package uwu.create.calamity.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import uwu.create.calamity.Calamity;

public class CalamityItemGroup {
    public static final ItemGroup CALAMITY = FabricItemGroupBuilder.build(new Identifier(Calamity.MODID, "calamity"),
            () -> new ItemStack(CalamityItems.TEST_ITEM));
}
