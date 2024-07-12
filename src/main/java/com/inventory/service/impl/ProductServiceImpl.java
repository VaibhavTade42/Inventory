package com.inventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Product;
import com.inventory.payload.ProductDto;
import com.inventory.repository.ProductRepository;
import com.inventory.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ProductDto saveProductDetails(ProductDto productDto) {
	Product savedProduct = 	productRepository.save(mapper.map(productDto, Product.class));
		return mapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public List<ProductDto> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto findProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto updateProductById(Long product_id, ProductDto updatedProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductById(Long product_id) {
		// TODO Auto-generated method stub
		
	}

	
}
