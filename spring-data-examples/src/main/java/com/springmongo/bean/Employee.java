package com.springmongo.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String empId;
	
	public Employee(){
		
	}
	
	public Employee(int id,String firstName,String lastName,String empId){
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.empId=empId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String toString(){
		StringBuilder employee=new StringBuilder();
		employee.append("Id:-").append(this.getId()).append("\n");
		employee.append("First Name:-").append(this.getFirstName()).append("\n");
		employee.append("Last Name:-").append(this.getLastName()).append("\n");
		employee.append("Employee Id:-").append(this.getEmpId()).append("\n");
		return employee.toString();
		
	}
	
	
}
