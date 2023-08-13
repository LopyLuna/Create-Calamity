package uwu.create.calamity.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import uwu.create.calamity.Calamity;
import uwu.create.calamity.block.entity.TestBlockEntity;

public class CalamityBlockEntities {
    public static BlockEntityType<TestBlockEntity> TEST_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        TEST_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Calamity.MODID, "test_block_entity"),
                FabricBlockEntityTypeBuilder.create(TestBlockEntity::new,
                        CalamityBlocks.TEST_BLOCK).build(null));
    }
}
