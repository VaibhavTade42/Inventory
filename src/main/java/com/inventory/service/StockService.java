package com.inventory.service;

import java.util.List;

import com.inventory.entity.Stock;

public interface StockService {

	
	Stock saveStockDetails(Stock stock);

	Stock getStockById(Long stockId);

	List<Stock> getAllStock();

	Stock updateStockById(Long stock_id, Stock stock);

}
