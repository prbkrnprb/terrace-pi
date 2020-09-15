package in.prabakaran.smarthome.tankapplication.service;

import java.util.HashMap;
import java.util.Map;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.event.GpioPinListener;

import in.prabakaran.smarthome.tankapplication.TankApplicationException;

public class PinStatus {

	private PinStatus() {
	}

	private static PinStatus pinStatus;

	public static PinStatus getInstance() {
		if (pinStatus == null) {
			pinStatus = new PinStatus();
		}
		return pinStatus;
	}

	private static final GpioController gpio = GpioFactory.getInstance();

	private final Map<Pin, GpioPinDigitalInput> inputPins = new HashMap<>();
	private final Map<Pin, GpioPinDigitalOutput> outputPins = new HashMap<>();

	public void setInputPin(final Pin pin, final String name, final PinPullResistance resistance,
			final GpioPinListener listener) throws TankApplicationException {
		if (inputPins.containsKey(pin)) {
			throw new TankApplicationException("Pin already exist as input: " + pin.getName());
		}
		if (outputPins.containsKey(pin)) {
			throw new TankApplicationException("Pin already exist as output: " + pin.getName());
		}
		final GpioPinDigitalInput inputPin = gpio.provisionDigitalInputPin(pin, name, resistance);
		inputPin.addListener(listener);
		inputPins.put(pin, inputPin);
	}

	public boolean isHigh(final Pin pin) throws TankApplicationException {
		if (!inputPins.containsKey(pin)) {
			throw new TankApplicationException("Pin not setup as input: " + pin.getName());
		}
		return inputPins.get(pin).isHigh();
	}

	public void setOutputPin(final Pin pin, final String name, final PinState state) throws TankApplicationException {
		if (inputPins.containsKey(pin)) {
			throw new TankApplicationException("Pin already exist as input: " + pin.getName());
		}
		if (outputPins.containsKey(pin)) {
			throw new TankApplicationException("Pin already exist as output: " + pin.getName());
		}
		outputPins.put(pin, gpio.provisionDigitalOutputPin(pin, name, state));
	}

	public void setStateHigh(final Pin pin, final boolean state) throws TankApplicationException {
		if (!outputPins.containsKey(pin)) {
			throw new TankApplicationException("Pin not setup as output: " + pin.getName());
		}
		if (state) {
			outputPins.get(pin).high();
		} else {
			outputPins.get(pin).low();
		}
	}

}
