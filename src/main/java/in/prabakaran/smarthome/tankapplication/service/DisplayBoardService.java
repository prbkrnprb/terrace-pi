package in.prabakaran.smarthome.tankapplication.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import in.prabakaran.smarthome.tankapplication.TankApplicationException;
import in.prabakaran.smarthome.tankapplication.model.TankDisplayMapper;

@Service
public class DisplayBoardService {

	private static PinStatus status = PinStatus.getInstance();

	public void update() {
		Arrays.asList(TankDisplayMapper.values()).forEach(mapper -> {
			try {
				status.setStateHigh(mapper.getBoard().getPins().getBottomPin(), ! status.isHigh(mapper.getTanks().getPins().getBottomPin()));
			} catch (final TankApplicationException e) {
				e.printStackTrace();
			}
			try {
				status.setStateHigh(mapper.getBoard().getPins().getMiddlePin(), status.isHigh(mapper.getTanks().getPins().getMiddlePin()));
			} catch (final TankApplicationException e) {
				e.printStackTrace();
			}
			try {
				status.setStateHigh(mapper.getBoard().getPins().getTopPin(), status.isHigh(mapper.getTanks().getPins().getTopPin()));
			} catch (final TankApplicationException e) {
				e.printStackTrace();
			}
		});
	}
}
