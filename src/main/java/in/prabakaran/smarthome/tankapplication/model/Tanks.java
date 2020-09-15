package in.prabakaran.smarthome.tankapplication.model;

import com.pi4j.io.gpio.RaspiPin;

public enum Tanks {
	
	FRESH_WATER("Fresh Water", new LevelPins(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03)),
	SALT_WATER("Salt Water", new LevelPins(RaspiPin.GPIO_04, RaspiPin.GPIO_05, RaspiPin.GPIO_06));
	
	private final Tank tank;
	private final LevelPins pins;
	
	private Tanks(final String name, final LevelPins pins) {
		tank = new Tank(name, pins);
		this.pins = pins;
	}

	public Tank getTank() {
		return tank;
	}

	public LevelPins getPins() {
		return pins;
	}
	
}
