package in.prabakaran.smarthome.tankapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

@Service
public class WaterSensorListenerService implements GpioPinListenerDigital {

	@Autowired
	private DisplayBoardService boardService;

	@Override
	public void handleGpioPinDigitalStateChangeEvent(final GpioPinDigitalStateChangeEvent event) {
		System.out.println(event.getPin().getName() + " : " + event.getState());
		boardService.update();
	}

}
