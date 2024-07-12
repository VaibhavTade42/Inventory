package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.Order;
import com.inventory.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/save-order")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		                 
		Order savedOrder = orderService.saveOrder(order);
		return new ResponseEntity<Order>(savedOrder, HttpStatus.CREATED);
	}

}
