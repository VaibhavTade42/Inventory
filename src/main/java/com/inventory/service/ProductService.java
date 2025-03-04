package com.inventory.service;

import java.util.List;

import com.inventory.entity.Product;
import com.inventory.payload.ProductDto;

public interface ProductService {

	ProductDto saveProductDetails(ProductDto productDto);

	List<ProductDto> findAllProducts();

	ProductDto findProductById(Long id);

	

	ProductDto updateProductById(Long productId, ProductDto updatedProduct);

	void deleteProductById(Long productId);

}
