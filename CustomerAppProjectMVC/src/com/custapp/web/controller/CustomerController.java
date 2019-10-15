package com.custapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.custapp.model.persistance.Customer;
import com.custapp.model.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	public CustomerService customerService;

	@RequestMapping(value = "allcustomers", method = RequestMethod.GET)
	public String getCustomer(ModelMap map) {

		map.addAttribute("customers", customerService.getAllCustomers());
		return "allcustomers";

	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.GET)
	public String addCustomerGet(ModelMap map) {
		map.addAttribute("customer", new Customer());
		return "addcustomer";

	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.POST)
	public String addCustomerPost(@Valid Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addcustomer";
		}
		if (customer.getCusId() == 0)
			customerService.addCustomer(customer);
		else
			customerService.updateCustomer(customer);
		return "redirect:allcustomers";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCustomer(HttpServletRequest req) {
		int cusId = Integer.parseInt(req.getParameter("cusId"));
		customerService.removeCustomer(cusId);
		return "redirect:allcustomers";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateCustomerGet(HttpServletRequest req, ModelMap map) {
		int cusId = Integer.parseInt(req.getParameter("cusId"));
		Customer customerToBeUpdate = customerService.getCustomerById(cusId);
		map.addAttribute("customer", customerToBeUpdate);
		return "addcustomer";
	}

}