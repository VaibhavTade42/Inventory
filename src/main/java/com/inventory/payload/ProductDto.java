package com.inventory.payload;

import java.util.Set;


import com.inventory.entity.Order;
import com.inventory.entity.Stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	
    private Long id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	//private Set<Order> orders;
	
	private Integer stockQuantity;

}
