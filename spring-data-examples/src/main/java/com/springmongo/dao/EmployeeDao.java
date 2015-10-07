package com.springmongo.dao;

import java.util.List;

import com.springmongo.bean.Employee;

public interface EmployeeDao {
	public void create(Employee employee);
	public void update(Employee employee);
	public int deleteById(int id);
	public Employee findById(int id);
	public List<Employee> findAll();
	public Employee prvDoc(int id);
	

}
