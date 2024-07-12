package com.inventory.service;

import java.util.List;

import com.inventory.entity.Product;

public interface ProductService {

	Product saveProductDetails(Product product);

	List<Product> findAllProducts();

	Product findProductById(Long id);

	

	Product updateProductById(Long product_id, Product updatedProduct);

	void deleteProductById(Long product_id);

}
