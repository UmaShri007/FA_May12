package ai.ineuron.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ai.ineuron.entity.Order;
import ai.ineuron.entity.User;
import ai.ineuron.service.IUserMgmtService;

@Component
public class AssociationRunner implements CommandLineRunner {

	@Autowired
	private IUserMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		// Save Operation Parent to Child ----> One To Many
		// Create a parent object
/*		User user = new User("Shah", "shah@gmail.com");

		// Create a child object
		Order o1 = new Order("Sengol", 2);
		Order o2 = new Order("Jackets", 3);
//		Order o3 = new Order("Sengol", 2, user);

		// link child to parent
		o1.setUser(user);
		o2.setUser(user);

		List<Order> orderDetails = List.of(o1, o2);

		// link parent to child
		user.setOrderDetails(orderDetails);

		System.out.println(service.saveUser(user));
*/	
		// load Operation from Parent to Child[1 to Many]
		
		service.fetchByUser().forEach(user -> {System.out.println("User :: " +
		  user); 
		  List<Order> orders = user.getOrderDetails();
		  orders.forEach(order -> { System.out.println("Order :: " + order); });
		  });
		 

	}
}
