package in.prabakaran.smarthome.tankapplication.model;

import com.pi4j.io.gpio.Pin;

public class LevelPins implements Cloneable {
	
	private final Pin bottomPin;
	private final Pin middlePin;
	private final Pin topPin;
	
	public LevelPins(final Pin bottomPin, final Pin middlePin, final Pin topPin) {
		this.bottomPin = bottomPin;
		this.middlePin = middlePin;
		this.topPin = topPin;
	}

	public Pin getBottomPin() {
		return bottomPin;
	}

	public Pin getMiddlePin() {
		return middlePin;
	}

	public Pin getTopPin() {
		return topPin;
	}
	
	@Override
	public LevelPins clone() {
		return new LevelPins(this.bottomPin, this.middlePin, this.topPin);		
	}

}
