package ai.ineuron.service;

import java.util.List;

import ai.ineuron.entity.Order;
import ai.ineuron.entity.User;

public interface IUserMgmtService {

	public String saveUser(User user);

	public Iterable<User> fetchByUser();
	

	}
