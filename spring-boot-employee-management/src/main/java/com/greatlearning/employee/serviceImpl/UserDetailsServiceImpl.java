package com.greatlearning.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.repository.RoleRepository;
import com.greatlearning.employee.repository.UserRepository;
import com.greatlearning.employee.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User insertUsers(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Role addNewRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Role getRoleById(Long id) {
		return this.roleRepository.findById(id).orElseThrow();
	}

	@Override
	public User getUserById(Long id) {
		return this.userRepository.findById(id).orElseThrow();
	}

	@Override
	public Role updateRole(Long id, Role updatedRole) {
		Role role = this.getRoleById(id);
		role.setRoleName(updatedRole.getRoleName());
		return this.roleRepository.save(role);
	}

	@Override
	public User updateUser(Long id, User updatedUser) {
		User user = this.getUserById(id);
		user.setUsername(updatedUser.getUsername());
		user.setPassword(updatedUser.getPassword());
		user.setRoles(updatedUser.getRoles());
		return this.userRepository.save(user);
	}

	@Override
	public String deleteRoleById(Long id) {
		roleRepository.deleteById(id);
		return "Deleted Role id: " + id;

	}

	@Override
	public String deleteUserById(Long id) {
		userRepository.deleteById(id);
		return "Deleted User id: " + id;

	}
}
