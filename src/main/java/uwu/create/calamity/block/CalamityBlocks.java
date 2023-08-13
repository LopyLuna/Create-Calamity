package uwu.create.calamity.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import uwu.create.calamity.Calamity;
import uwu.create.calamity.block.custom.TestBlock;
import uwu.create.calamity.item.CalamityItemGroup;

public class CalamityBlocks {
    public static final Block TEST_BLOCK = registerBlock("test_block",
            new TestBlock(FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.GRAVEL).mapColor(DyeColor.BROWN)
                    .hardness(0.5f).strength(0.5f).luminance(15)), CalamityItemGroup.CALAMITY);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Calamity.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Calamity.MODID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(Calamity.MODID, name), block);
    }

    public static void registerBlocks() {
        Calamity.devLogger("Registering " + Calamity.MODID + " Mod blocks");
    }
}
