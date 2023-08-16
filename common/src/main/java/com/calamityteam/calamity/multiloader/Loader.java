package com.calamityteam.calamity.multiloader;

import java.util.function.Supplier;

import org.jetbrains.annotations.ApiStatus.Internal;

import dev.architectury.injectables.annotations.ExpectPlatform;

public enum Loader {
	FORGE, FABRIC;

	public static final Loader CURRENT = getCurrent();

	public boolean isCurrent() {
		return this == CURRENT;
	}

	public void runIfCurrent(Supplier<Runnable> run) {
		if (isCurrent())
			run.get().run();
	}

	@Internal
	@ExpectPlatform
	public static Loader getCurrent() {
		throw new AssertionError();
	}
}
