package com.example.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.Login;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	//create
	@PostMapping("/create")
	public User createUser(@Validated @RequestBody User user) {
		return userRepository.save(user);
	}
	
	//Read
	@GetMapping("/get")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	//Update
//	@PutMapping("/update/{id}")
//	public User updateUser(@RequestBody User user, @PathVariable int id) {
//		User users = userRepository.findById(user.getId()).orElse(null);
//		users.setId(user.getId());	
//		users.setName(user.getName());
//		users.setEmail(user.getEmail());
//		users.setPassword(user.getPassword());
//		users.setPhone(user.getPhone());
//		
//		return userRepository.save(users);
//	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	

	//Delete
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		userRepository.deleteById(id);
		
		return "deleted";
	}
	
//	@DeleteMapping("/delete/{id}")
//	public boolean deleteUser(@PathVariable int id) {
//		try {
//			userRepository.deleteById(id);
//			return true;
//		}
//		catch(Exception e) {
//			return false;
//		}
//	}
	
	//get by id
	@GetMapping("/get/{id}")
	public Optional<User> getUsersById(@PathVariable int id) {
		return userRepository.findById(id);
	}
	
//	 //get by id
//		@GetMapping("/get/{id}")
//		public User getUsersById(@PathVariable int id) {
//			return userRepository.findById(id).orElse(null);
//		}
	
	
	@PostMapping("login")
	public User loginUser(@RequestBody Login login) {
		return userRepository.findByIdAndPassword(login.getId(),login.getPassword());
		
	}
	
}
