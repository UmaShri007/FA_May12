package ai.ineuron.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	public void doQuestion1(String ans1) {
		
	System.out.println("PrimeMinister of India: "+ans1);
	
	}
	
	public void doQuestion2(Integer ans2) {
		
		System.out.println("Zero multiplied by any number: "+ans2);
		
	}
	
	public Double doQuestion3(Double ans3) {
		
		System.out.println("Gravitational Force off Earth:: "+ans3);
		return ans3;
	}
}
