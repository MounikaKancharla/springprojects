package spring.mvc.mongo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import spring.mvc.mongo.bean.Customer;
import spring.mvc.mongo.service.CustomerService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CustomerController {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) {
	 * logger.info("Welcome home! The client locale is {}.", locale);
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate );
	 * 
	 * return "home"; }
	 */

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String getCustomerlist(ModelMap model) {
		model.addAttribute("customerList", customerService.listCustomers());
		return "customerdetails";

	}

	@RequestMapping(value = "/customer/save", method = RequestMethod.POST)
	public View saveCustomer(@RequestBody Customer customer, ModelMap model) {
		customerService.saveCustomer(customer);
		return new RedirectView("/mongo/customer");
	}

	@RequestMapping(value = "/customerinfo/{id}/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomerInfo(
			@PathVariable String id, @PathVariable("name") String fname, ModelMap model) {
		List<Customer> cust = customerService.listCustomers();
		return new ResponseEntity<List<Customer>>(cust, HttpStatus.OK);
	}

}
