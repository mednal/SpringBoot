package tn.esprit.services;

import tn.esprit.model.Stock;

import java.util.List;

public interface stockService {

    public void addStock(Stock stock);
    public void UpdateStock(Stock stock,long id);
    public Stock getStockById(long id);
    public List<Stock> getAllStock();
    public void deleteStockById(long id);
    public void deleteAllStocks();
}
