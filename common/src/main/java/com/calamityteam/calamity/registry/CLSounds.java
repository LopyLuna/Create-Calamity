package com.calamityteam.calamity.registry;

import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;

import com.calamityteam.calamity.Calamity;
import com.tterrag.registrate.util.entry.RegistryEntry;

public class CLSounds {
	public static final SoundEvent PLUSHIE_506 = registerSound("plushie_506").get();
	public static final SoundEvent PLUSHIE_ILLUC = registerSound("plushie_illuc").get();
	public static final SoundEvent PLUSHIE_KELAD8 = registerSound("plushie_kelad8").get();
	public static final SoundEvent PLUSHIE_MILKYFUR_BLUSH = registerSound("plushie_milkyfur_blush").get();
	public static final SoundEvent PLUSHIE_MILKYFUR_HONK = registerSound("plushie_milkyfur_honk").get();
	public static final SoundEvent PLUSHIE_OUTCRAFT = registerSound("plushie_outcraft").get();
	public static final SoundEvent PLUSHIE_REDS = registerSound("plushie_reds").get();
	public static final SoundEvent PLUSHIE_SASCHA = registerSound("plushie_sascha").get();
	public static final SoundEvent PLUSHIE_SHIROJR = registerSound("plushie_shirojr").get();
	public static final SoundEvent PLUSHIE_THESPOKESMAN = registerSound("plushie_tespokesman").get();
	public static final SoundEvent PLUSHIE_TO0PA = registerSound("plushie_to0pa").get();

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
		return Calamity.REGISTRATE.simple(
			id, Registry.SOUND_EVENT_REGISTRY,
			() -> new SoundEvent(Calamity.asResource(id))
		);
	}

	public static void register() {
	}
}