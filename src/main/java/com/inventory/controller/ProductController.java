package com.inventory.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.Product;
import com.inventory.entity.Stock;
import com.inventory.payload.ProductDto;
import com.inventory.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/save-product")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
	    Product product =   mapper.map(productDto, Product.class);
	    
	    if (productDto.getStockQuantity() != null) {
            Stock stock = new Stock();
            stock.setQuantity(productDto.getStockQuantity());
            stock.setProducts(product);
            product.setStock(stock);
        }
        ProductDto savedProduct = productService.saveProductDetails(productDto);
        return ResponseEntity.ok(savedProduct);
		
	}
	
	@GetMapping("/get-all-products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> getAllProducts = productService.findAllProducts();
		return ResponseEntity.ok(getAllProducts);
	}
	
//	@GetMapping("/get-productById/{product_id}")
//	public ResponseEntity<Product> getProductById(@PathVariable("product_id") Long id){
//		ProductDto product = productService.findProductById(id);
//		if (product != null) {
//            return ResponseEntity.ok(product);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//	}
//	
//	@PutMapping("/updateProductById/{id}")
//	public ResponseEntity<Product> updateEmployeeUsingId(@PathVariable("id") Long product_id, @RequestBody Product updatedProduct){
//		Product product = productService.updateProductById(product_id, updatedProduct);
//	return ResponseEntity.ok(product);
//	}
	
	@DeleteMapping("/delete-productById/{id}")
	public void deleteProduct(@PathVariable("id") Long product_id ){
		productService.deleteProductById(product_id);
		 ResponseEntity.ok("Product deleted successfully");
		
	}
}
