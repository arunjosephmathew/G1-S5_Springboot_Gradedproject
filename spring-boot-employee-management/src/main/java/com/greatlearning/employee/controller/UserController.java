package com.greatlearning.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.service.UserDetailsService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserDetailsService userService;

	@Autowired
	public UserController(UserDetailsService theUserService) {
		userService = theUserService;
	}

	@ApiOperation(value = "Add Role", notes = "This API allows you to add a Role to Roles table")
	@PostMapping("/role")
	public Role addNewRole(@RequestBody Role roles) {
		return userService.addNewRole(roles);
	}

	@ApiOperation(value = "Add User", notes = "This API allows you to add an User to Users table")
	@PostMapping("/user")
	public User insertUsers(@RequestBody User user) {
		return userService.insertUsers(user);
	}

	@GetMapping("/role")
	public List<Role> getAllRole() {
		return userService.getAllRole();
	}

	@GetMapping("/user")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@PutMapping("/role/{id}")
	public Role updateRole(@PathVariable("id") Long id, @RequestBody Role updatedRole) {
		return userService.updateRole(id, updatedRole);
	}

	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
		return userService.updateUser(id, updatedUser);
	}

	@DeleteMapping("/role/{id}")
	public String deleteRoleById(@PathVariable("id") Long id) {
		return userService.deleteRoleById(id);
	}

	@DeleteMapping("/user/{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
		return userService.deleteUserById(id);
	}
}
