package in.prabakaran.smarthome.tankapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.prabakaran.smarthome.tankapplication.model.Tank;
import in.prabakaran.smarthome.tankapplication.service.LevelCheckService;

@RestController
public class StatusController {
	
	@Autowired
	private LevelCheckService levelCheck;

	@RequestMapping("/")
	public List<Tank> index() {
		return levelCheck.retrieveStatus();
	}

}