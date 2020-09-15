package in.prabakaran.smarthome.tankapplication;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import in.prabakaran.smarthome.tankapplication.model.DisplayBoard;
import in.prabakaran.smarthome.tankapplication.model.Tanks;
import in.prabakaran.smarthome.tankapplication.service.DisplayBoardService;

@SpringBootApplication
public class WaterTankApplication {
	
	@Autowired
	private PinStatusHelper helper;
	
	@Autowired
	private DisplayBoardService boardService;
	
	@EventListener
	public void setupPins(final ContextRefreshedEvent event) {
		Arrays.stream(Tanks.values()).map(Tanks::getPins).forEach(helper::setInputPins);
		Arrays.stream(DisplayBoard.values()).map(DisplayBoard::getPins).forEach(helper::setOutputPins);
		boardService.update();
	}
	
	public static void main(String args[]) throws InterruptedException {
		SpringApplication.run(WaterTankApplication.class, args);
       
    }
}
