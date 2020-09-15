package in.prabakaran.smarthome.tankapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Tank implements Cloneable {

	private TankStatus status;
	@JsonIgnore
	private final LevelPins pins;
	private final String name;

	public Tank(final String name, final LevelPins pins) {
		this.name = name;
		this.pins = pins;
	}

	public TankStatus getStatus() {
		return status;
	}

	public void setStatus(final TankStatus status) {
		this.status = status;
	}

	public LevelPins getPins() {
		return pins;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public Tank clone() {
		return new Tank(this.name, this.getPins().clone());
	}
}
