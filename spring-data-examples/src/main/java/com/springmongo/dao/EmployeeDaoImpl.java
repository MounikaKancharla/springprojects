package com.springmongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.springmongo.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	//private static final String COLLECTION = "Employee";
	@Autowired
	MongoTemplate mongoTemplate;

	// Create operation
	public void create(Employee employee) {
		if (employee != null) {
			this.mongoTemplate.insert(employee);
		}

	}

	// Read Operation
	public Employee findById(int id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoTemplate.findOne(query, Employee.class);
	}

	// Update operation
	public void update(Employee employee) {
		if (employee != null) {
			this.mongoTemplate.save(employee);
		}
	}

	// Delete Operation
	public int deleteById(int id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoTemplate.remove(query, Employee.class
				);
		return result.getN();
	}

	// findAll Operation
	public List findAll() {
		return (List) mongoTemplate.findAll(Employee.class);
	}

	public Employee prvDoc(int id) {

		Query query = new Query(Criteria.where("_id").is(id));
		query.with(new Sort(Sort.Direction.ASC, "lastName"));
		query.fields();
		Update update = new Update();
		update.set("lastName", "lsn1111");
		Employee employee = mongoTemplate.findAndModify(query, update,
				new FindAndModifyOptions().returnNew(false), Employee.class);
		return employee;
		/*
		 * update6.set("age", 101); update6.set("ic", 1111);
		 * 
		 * //FindAndModifyOptions().returnNew(true) = newly updated document
		 * //FindAndModifyOptions().returnNew(false) = old document (not update
		 * yet) User userTest6 = mongoOperation.findAndModify( query6, update6,
		 * new FindAndModifyOptions().returnNew(true), User.class);
		 * System.out.println("userTest6 - " + userTest6);
		 */

	}

}
