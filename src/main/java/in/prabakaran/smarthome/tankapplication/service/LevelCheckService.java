package in.prabakaran.smarthome.tankapplication.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.prabakaran.smarthome.tankapplication.TankApplicationException;
import in.prabakaran.smarthome.tankapplication.model.Tank;
import in.prabakaran.smarthome.tankapplication.model.LevelPins;
import in.prabakaran.smarthome.tankapplication.model.TankStatus;
import in.prabakaran.smarthome.tankapplication.model.Tanks;

@Service
public class LevelCheckService {

	private PinStatus pinStatus = PinStatus.getInstance();

	public List<Tank> retrieveStatus() {
		return Arrays.stream(Tanks.values())
				.map(Tanks::getTank)
				.map(Tank::clone)
				.map(tank -> {
					final LevelPins pins = tank.getPins();
					final TankStatus status = new TankStatus();
					try {
						status.setBottomProbe(pinStatus.isHigh(pins.getBottomPin()));
					} catch (TankApplicationException e) {
						e.printStackTrace();
					}
					try {
						status.setMiddleProbe(pinStatus.isHigh(pins.getMiddlePin()));
					} catch (TankApplicationException e) {
						e.printStackTrace();
					}
					try {
						status.setTopProbe(pinStatus.isHigh(pins.getTopPin()));
					} catch (TankApplicationException e) {
						e.printStackTrace();
					}
					tank.setStatus(status);
					return tank;
				}).collect(Collectors.toList());
	}

}
