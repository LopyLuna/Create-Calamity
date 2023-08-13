package uwu.create.calamity.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import uwu.create.calamity.block.CalamityBlockEntities;

public class TestBlockEntity extends BlockEntity {
    public TestBlockEntity(BlockPos pos, BlockState state) {
        super(CalamityBlockEntities.TEST_BLOCK_ENTITY, pos, state);
    }
}
