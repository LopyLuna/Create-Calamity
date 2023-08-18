package com.calamityteam.calamity.registry;

import com.calamityteam.calamity.Calamity;
import com.calamityteam.calamity.base.block.Canister.CanisterBlockEntity;
import com.calamityteam.calamity.base.block.PneumaticIO.PneumaticIOBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;

public class CLBlockEntities {

	public static final BlockEntityEntry<PneumaticIOBlockEntity> PNEUMATIC_IO_ENTITY = 	Calamity.REGISTRATE.blockEntity("pneumatic_io_entity",PneumaticIOBlockEntity::new)
		.validBlock(CLBlocks.PNEU_IO)
		.register();
	public static final BlockEntityEntry<CanisterBlockEntity> CANISTER_ENTITY = 	Calamity.REGISTRATE.blockEntity("canister_entity",CanisterBlockEntity::new)
		.validBlock(CLBlocks.CANISTER)
		.register();

	public static void register() {
	}
}
