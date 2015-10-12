package spring.mvc.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import spring.mvc.mongo.bean.Customer;

public class CustomerService {
	@Autowired
	private MongoTemplate mongoTemplate;
	private final String collectionName = "customer";

	public void saveCustomer(Customer customer) {
		if (!mongoTemplate.collectionExists(Customer.class)) {
			mongoTemplate.createCollection(Customer.class);
		}

		mongoTemplate.insert(customer, "customer");

	}

	public List<Customer> listCustomers() {
		return mongoTemplate.findAll(Customer.class, "customer");

	}

}
