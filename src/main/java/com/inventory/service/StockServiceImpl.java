package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Product;
import com.inventory.entity.Stock;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.StockRepository;



@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Stock saveStockDetails(Stock stock) {
		
	Long productId = stock.getProduct().getId();
	Product product =productRepository.findById(productId).orElseThrow(
			()->new RuntimeException("Product not found with product id "+productId));
	
	stock.setProduct(product);
		Stock savedStock = stockRepository.save(stock);
		return savedStock;
	}

	@Override
	public Stock getStockById(Long stockId) {
	    return stockRepository.findById(stockId).orElseThrow(
	    		()->new RuntimeException("Stock not found with id "+stockId));
		
	}

	@Override
	//@Transactional
	public List<Stock> getAllStock() {
		
		List<Stock> allstock = stockRepository.findAll();
		return allstock;
	}

	@Override
	  public Stock updateStockById(Long stock_id, Stock stock) {
	        Stock stockUpdate = stockRepository.findById(stock_id).orElseThrow(
	            () -> new RuntimeException("Stock not found with id: " + stock_id));
	        
	        // Check if the product exists
	        Long productId = stock.getProduct().getId();
	        Product product = productRepository.findById(productId).orElseThrow(
	            () -> new RuntimeException("Product not found with product id " + productId));
	        
	        stockUpdate.setProduct(product);
	        stockUpdate.setQuantity(stock.getQuantity());
	        
	        return stockRepository.save(stockUpdate);
	    }

	

}
