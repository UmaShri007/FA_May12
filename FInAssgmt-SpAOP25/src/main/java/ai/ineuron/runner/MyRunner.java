package ai.ineuron.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ai.ineuron.service.MyService;

@Component
public class MyRunner implements CommandLineRunner{

	@Autowired
	private MyService service;
	
	@Override
	public void run(String... args) throws Exception {

		service.doQuestion1("Modi");
		service.doQuestion2(0);
		service.doQuestion3(9.8);
		
	}

}
