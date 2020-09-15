package in.prabakaran.smarthome.tankapplication;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;

import in.prabakaran.smarthome.tankapplication.model.LevelPins;
import in.prabakaran.smarthome.tankapplication.service.PinStatus;
import in.prabakaran.smarthome.tankapplication.service.WaterSensorListenerService;

@Component
public class PinStatusHelper {

	private PinStatus status = PinStatus.getInstance();

	@Autowired
	private WaterSensorListenerService listener;

	public void setInputPins(final LevelPins pins) {
		try {
			status.setInputPin(pins.getBottomPin(), " Bottom", PinPullResistance.PULL_DOWN, listener);
		} catch (final TankApplicationException e) {
			e.printStackTrace();
		}
		try {
			status.setInputPin(pins.getMiddlePin(), " Middle", PinPullResistance.PULL_DOWN, listener);
		} catch (final TankApplicationException e) {
			e.printStackTrace();
		}
		try {
			status.setInputPin(pins.getTopPin(), " Top", PinPullResistance.PULL_DOWN, listener);
		} catch (final TankApplicationException e) {
			e.printStackTrace();
		}
	}

	public void setInputPins(final Map<Pin, String> pins) {
		for (final Entry<Pin, String> pin : pins.entrySet()) {
			try {
				status.setInputPin(pin.getKey(), pin.getValue(), PinPullResistance.PULL_DOWN, listener);
			} catch (final TankApplicationException e) {
				e.printStackTrace();
			}
		}
	}

	public void setOutputPins(final LevelPins pins) {
		try {
			status.setOutputPin(pins.getBottomPin(), " Bottom", PinState.LOW);
		} catch (final TankApplicationException e) {
			e.printStackTrace();
		}
		try {
			status.setOutputPin(pins.getMiddlePin(), " Middle", PinState.LOW);
		} catch (final TankApplicationException e) {
			e.printStackTrace();
		}
		try {
			status.setOutputPin(pins.getTopPin(), " Top", PinState.LOW);
		} catch (final TankApplicationException e) {
			e.printStackTrace();
		}
	}
}
