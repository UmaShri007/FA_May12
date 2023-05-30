package ai.ineuron.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.ineuron.dao.IUserRepository;
import ai.ineuron.model.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public void registerUser(User user)  {
		userRepo.save(user);
	}

}
