package ai.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.ineuron.dao.IOrderRepository;
import ai.ineuron.dao.IUserRepository;
import ai.ineuron.entity.Order;
import ai.ineuron.entity.User;

@Service
public class UserServiceMgmtImpl implements IUserMgmtService {

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private IOrderRepository orderRepo;
	
	@Override
	public String saveUser(User user) {
		Long idValue = userRepo.save(user).getUid();
		return "User and his order details are saved with id value :: " + idValue;
	}

	@Override
	public Iterable<User> fetchByUser() {
		return userRepo.findAll();
		 	
	}

}
