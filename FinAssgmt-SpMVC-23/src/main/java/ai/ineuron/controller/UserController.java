package ai.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.ineuron.model.User;
import ai.ineuron.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	@PostMapping("/save")
	public String registerUser(@ModelAttribute("user") User user) {
		System.out.println(user);
		service.registerUser(user);
		return "redirect:/api/user";
	}
}
