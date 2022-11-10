package com.greatlearning.employee.service;

import java.util.List;

import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.entity.User;

public interface UserDetailsService {

	User insertUsers(User user);

	Role addNewRole(Role role);

	List<Role> getAllRole();

	List<User> getAllUser();

	Role getRoleById(Long id);

	Role updateRole(Long id, Role updatedRole);

	String deleteRoleById(Long id);

	User getUserById(Long id);

	User updateUser(Long id, User updatedUser);

	String deleteUserById(Long id);

}
