package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.Stock;
import com.inventory.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@PostMapping("/save-stock")
	public ResponseEntity<Stock> createStock(@RequestBody Stock stock){
		Stock savedStock = stockService.saveStockDetails(stock);
		return new ResponseEntity<Stock>(savedStock, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-stockById/{id}")
	public ResponseEntity<Stock> getStockById(@PathVariable("id") Long stockId){
		Stock getStockById = stockService.getStockById(stockId);
		return ResponseEntity.ok(getStockById);
	}
	
	@GetMapping("/get-allStock")
	public ResponseEntity<List<Stock>> getAllStock() {
	List<Stock> allStock = stockService.getAllStock();
	return ResponseEntity.ok(allStock);
	}
	
	@PutMapping("/update-stock/{id}")
	public ResponseEntity<Stock> updateStock(@PathVariable("id") Long stock_id, @RequestBody Stock stock){
		Stock updateStock = stockService.updateStockById(stock_id, stock);
		return ResponseEntity.ok(updateStock);
	}
	

}
