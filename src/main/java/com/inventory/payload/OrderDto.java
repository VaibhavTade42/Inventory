package com.inventory.payload;

import java.util.Date;
import java.util.Set;
import com.inventory.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	
    private Long id;

	private Set<Product> products;
	
	private int quantity;
	
	private Date orderDate;


}
