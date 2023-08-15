package com.calamityteam.calamity.feature.research_mode.researches;

public enum Negatives {
	PIPE_BOMBS("pipe_bombs", Features.PNEUMATIC_PIPES),
	STEEL_RNG("steel_rng", false),
	WORKSPACE_HAZARDS("workspace_hazards", false),

	;
	private String name;
	private float randomChanceBonus;
	private Features linkedFeature;
	private boolean isLinked;
	private Negatives(String name, Features linkedFeature) {
	}
	private Negatives(String name, boolean isLinked) {
	}
	public String getName() {
		return name;
	}
	public float getRandomChanceBonus() {
		return randomChanceBonus;
	}
	public Features getLinkedFeature() {
		return linkedFeature;
	}
	public boolean isLinked() {
		return isLinked;
	}
	public void getAllNegatives() {
		for (Negatives negative : Negatives.values()) {
			System.out.println(negative.getName());
		}
	}
	public Negatives getRandomNegative() {
		int random = (int) (Math.random() * Negatives.values().length);
		System.out.println(Negatives.values()[random].getName());
		return Negatives.values()[random];
	}
	public boolean isLoaded(Negatives negative) {
		return true;
	}

}
