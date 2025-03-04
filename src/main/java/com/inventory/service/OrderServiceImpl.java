package com.inventory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Order;
import com.inventory.entity.Product;
import com.inventory.repository.OrderRepository;
import com.inventory.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
    private ProductRepository productRepository;

	@Override
	public Order saveOrder(Order order) {
		Long productId = order.getProduct().getId();
	Product product = productRepository.findById(order.getProduct().getId()).orElseThrow(
			()->new RuntimeException("Product is not found with id: "+productId));
	 
	 
	 order.setProduct(product);
	Order savedOrder = orderRepository.save(order);
	
		return savedOrder;
		
	}

}
