package com.calamityteam.calamity.base.registries;

import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;

import com.calamityteam.calamity.CreateCalamity;
import com.tterrag.registrate.util.entry.RegistryEntry;

public class SoundRegistry {
	public static final RegistryEntry<SoundEvent> PLUSHIE_506 = registerSound("plushie_506");
	public static final RegistryEntry<SoundEvent> PLUSHIE_ILLUC = registerSound("plushie_illuc");
	public static final RegistryEntry<SoundEvent> PLUSHIE_KELAD8 = registerSound("plushie_kelad8");
	public static final RegistryEntry<SoundEvent> PLUSHIE_MILKYFUR_BLUSH = registerSound("plushie_milkyfur_blush");
	public static final RegistryEntry<SoundEvent> PLUSHIE_MILKYFUR_HONK = registerSound("plushie_milkyfur_honk");
	public static final RegistryEntry<SoundEvent> PLUSHIE_OUTCRAFT = registerSound("plushie_outcraft");
	public static final RegistryEntry<SoundEvent> PLUSHIE_REDS = registerSound("plushie_reds");
	public static final RegistryEntry<SoundEvent> PLUSHIE_SASCHA = registerSound("plushie_sascha");
	public static final RegistryEntry<SoundEvent> PLUSHIE_SHIROJR = registerSound("plushie_shirojr");
	public static final RegistryEntry<SoundEvent> PLUSHIE_THESPOKESMAN = registerSound("plushie_tespokesman");
	public static final RegistryEntry<SoundEvent> PLUSHIE_TO0PA = registerSound("plushie_to0pa");

	/**
	 * Register sound events <br><br>
	 *
	 * <b>Important information:</b>
	 * <ul>
	 *     <li>Sound files need to be added as an .ogg file in mono (only one audio channel)</li>
	 *     <li> <b><i>id</i></b> needs to match with the sound file's name</li>
	 *     <li>Sound entry needs to be added to the
	 *     <i>resources/assets/createcalamity/sounds.json</i></li>
	 * </ul>
	 */
	private static RegistryEntry<SoundEvent> registerSound(String id) {
		return CreateCalamity.REGISTRATE.simple(
			id, Registry.SOUND_EVENT_REGISTRY,
			() -> new SoundEvent(CreateCalamity.asResource(id))
		);
	}

	public static void register() {
	}
}