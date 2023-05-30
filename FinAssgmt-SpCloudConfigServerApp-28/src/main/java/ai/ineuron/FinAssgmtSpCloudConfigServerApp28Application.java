package ai.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FinAssgmtSpCloudConfigServerApp28Application {

	public static void main(String[] args) {
		SpringApplication.run(FinAssgmtSpCloudConfigServerApp28Application.class, args);
	}

}
