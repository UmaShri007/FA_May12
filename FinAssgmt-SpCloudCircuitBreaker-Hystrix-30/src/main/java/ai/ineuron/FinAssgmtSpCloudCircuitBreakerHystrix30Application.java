package ai.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableHystrixDashboard
@EnableHystrix

public class FinAssgmtSpCloudCircuitBreakerHystrix30Application {

	public static void main(String[] args) {
		SpringApplication.run(FinAssgmtSpCloudCircuitBreakerHystrix30Application.class, args);
	}

}
