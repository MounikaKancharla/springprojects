package com.springmongo.mainapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmongo.bean.Employee;
import com.springmongo.dao.EmployeeDao;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-beans.xml");
		EmployeeDao employeeDao=(EmployeeDao)context.getBean("employeeDao");
		
		Employee emp1=new Employee();
		emp1.setFirstName("Rajesh");
		emp1.setLastName("Kumar");
		emp1.setId(1);
		emp1.setEmpId("abc");
		
		employeeDao.create(emp1);
		
		
		
		Employee emp2=new Employee();
		emp2.setFirstName("Mahesh");
		emp2.setLastName("Kumar");
		emp2.setId(2);
		emp2.setEmpId("xyz");
		
		
		
		//create operation
		
		
		employeeDao.create(emp2);
		
		System.out.println("List After Employee Creation");
		System.out.println("-----------------------------");
		
		 for (Employee e : employeeDao.findAll()) {
			   System.out.println(e);
			  }
		 
		 System.out.println("@@@@@@@@@@@@@@@@@@@@"+employeeDao.prvDoc(1));
		 
		//update Operation
		emp1.setFirstName("Sai-Upadate");
		employeeDao.update(emp1);
		System.out.println("List After Employee Updation");
		System.out.println("-----------------------------");
		
		for (Employee e : employeeDao.findAll()) {
			   System.out.println(e);
			  }
		employeeDao.deleteById(2);
		System.out.println("List After Employee Deletion");
		System.out.println("-----------------------------");
		
		for(Employee e:employeeDao.findAll()){
			 System.out.println(e);
		}
		
		//find by id
		System.out.println("Find By Id");
		System.out.println("-----------");
		System.out.println(employeeDao.findById(1));
		
		
	}

}
