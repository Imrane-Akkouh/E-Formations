package com.apollo.ApolloProject.Mongo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apollo.ApolloProject.Bean.Order;
import com.apollo.ApolloProject.Mongo.DAO.OrderRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowedHeaders = {""})
@RequestMapping("/order")
public class OrderController {

	
	@Autowired
    @Lazy
    private OrderRepository orderRepo;
	
	// add a order to mongodb store 
	@RequestMapping("/add")
	@PostMapping
	public Order addOrder(@RequestBody Order order) {
		return orderRepo.save(order);  
	}
	
	// list all the orders from mongodb store
	@RequestMapping("/all")
	@GetMapping
	public Iterable<Order> getOrder() { 
		return  orderRepo.findAll(); 
	}
	
	// update the order data in mongodb store
	@RequestMapping("/update")
	@PostMapping
	public Order update(@RequestBody Order order) {
		Long id = order.getId();
		orderRepo.deleteById(id);
		return orderRepo.save(order);
	}
	
	// delete order by id  from mongodb store 
	@RequestMapping("/delete/{id}")
	@GetMapping
	public void remove(@PathVariable Long id) {
		
		orderRepo.deleteById(id);
	}

}
