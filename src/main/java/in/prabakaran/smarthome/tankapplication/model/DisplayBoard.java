package in.prabakaran.smarthome.tankapplication.model;

import com.pi4j.io.gpio.RaspiPin;

public enum DisplayBoard {
	
	SALT_WATER("Salt Water", new LevelPins(RaspiPin.GPIO_27, RaspiPin.GPIO_28, RaspiPin.GPIO_29)),
	FRESH_WATER("Fresh Water", new LevelPins(RaspiPin.GPIO_23, RaspiPin.GPIO_24, RaspiPin.GPIO_25));
	
	private final String name;
	private final LevelPins pins;
	
	private DisplayBoard(final String name, final LevelPins pins) {
		this.name = name;
		this.pins = pins;
	}

	public String getName() {
		return name;
	}

	public LevelPins getPins() {
		return pins;
	}

}
