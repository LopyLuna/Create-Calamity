package com.calamityteam.calamity.registry;



import com.calamityteam.calamity.base.item.TrumpetItem;
import com.tterrag.registrate.util.entry.ItemEntry;

import static com.calamityteam.calamity.Calamity.REGISTRATE;

public class CLItems {

	static {
		REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_TAB);
	}

	public static final ItemEntry<TrumpetItem> TRUMPET = REGISTRATE.item("trumpet", TrumpetItem::new)
		.register();

	public static void register() {
	}
}
