package com.greatlearning.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.service.EmployeeService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@ApiOperation(value = "Add Single Employee", notes = "This API allows you to add a single Employee to Employee table")
	@PostMapping
	public String addSingleEmployee(@RequestBody Employee employee) {
		return empService.addSingleEmployee(employee);
	}

	@ApiOperation(value = "Add Multiple Employees", notes = "This API allows you to add multiple Employees to Employee table")
	@PostMapping("/insertAllEmployees")
	public String insertAllEmployees(@RequestBody List<Employee> employee) {
		return empService.addAllEmployees(employee);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee updatedEmployee) {
		return empService.updateEmployee(id, updatedEmployee);
	}

	@ApiOperation(value = "Prune Table", notes = "This API allows you to prune Employee table")
	@DeleteMapping("/deleteAllEmployees")
	public String pruneEmployees() {
		return empService.pruneEmployees();
	}

	@ApiOperation(value = "Delete All Employees In Batch Mode", notes = "This API allows you to delete all Employees present in the Employee table in batch mode")
	@DeleteMapping("/deleteAllBatch")
	public String deleteAllInBatch(@RequestBody List<Employee> employees) {
		return empService.deleteAllInBatch(employees);
	}

	@ApiOperation(value = "Delete Employee By Id", notes = "This API allows you to delete single Employee at a time by ID")
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id) {
		return empService.deleteEmployeeById(id);
	}

	@GetMapping
	public List<Employee> getAllEmployee() {
		return empService.getAllEmployee();
	}

	@GetMapping("/findByFirstname")
	public List<Employee> getEmployeesWithFirstName(String firstName) {
		return empService.getEmployeesWithFirstName(firstName);
	}

	@GetMapping("/{id}")
	public Employee getAnEmployeeById(@PathVariable("id") Long id) {
		return empService.getAnEmployeeById(id);
	}

	@GetMapping("/sort")
	public List<Employee> getEmployeesWithLatestAddedOrder() {
		return empService.getEmployeesWithLatestAddedOrder();

	}

	@GetMapping("/sort/id")
	public List<Employee> getEmployeesCustomSortedById(Direction direction) {
		return empService.getEmployeesCustomSortedById(direction);
	}

	@GetMapping("/sort/name")
	public List<Employee> getEmployeesCustomSortedByFirstName(Direction direction) {
		return empService.getEmployeesCustomSortedByFirstName(direction);
	}

}
