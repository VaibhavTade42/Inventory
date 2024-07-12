package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Product;
import com.inventory.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProductDetails(Product product) {
		
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public List<Product> findAllProducts() {
	
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(Long id) {
		 Optional<Product> optionalProduct = productRepository.findById(id);
	        return optionalProduct.orElse(null);
	}

	@Override
	public Product updateProductById(Long product_id, Product product) {
		Product productById =productRepository.findById(product_id).orElse(null);
		
		productById.setName(product.getName());
		productById.setDescription(product.getDescription());
		productById.setPrice(product.getPrice());
		
		return productRepository.save(productById);
	}

	@Override
	public void deleteProductById(Long product_id) {
		
		Product product = productRepository.findById(product_id).orElse(null);
		 productRepository.deleteById(product_id);
	}

	
}
