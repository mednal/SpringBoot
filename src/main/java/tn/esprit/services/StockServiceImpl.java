package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.StockRepository;
import tn.esprit.model.Stock;

import java.util.List;

@Service
public class StockServiceImpl implements stockService{
    @Autowired
    StockRepository stockRepository;
    @Override
    public void addStock(Stock stock) {
        if(!stockRepository.findById(stock.getIdStock()).isPresent()){
            stockRepository.save(stock);
        }

    }

    @Override
    public Stock getStockById(long id) {
        return   stockRepository.findById(id).get();
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public void deleteStockById(long id) {
        stockRepository.findById(id);
    }

    @Override
    public void deleteAllStocks() {
        stockRepository.deleteAll();
    }
@Scheduled(fixedDelay = 6000)
    @Override
    public void AlertRepture() {
 List<Stock>stocks=stockRepository.findAll();
 String alert="";
 for(Stock st:stocks)
     if(st.getQte()==0)
     {
         alert="out of stock";
System.out.println(alert);
     }

    }

    @Override
    public void UpdateStock(Stock stock, long id) {
        Stock st=stockRepository.findById(id).get();

        if(stock.getLibellStock()!=null) st.setLibellStock(stock.getLibellStock());

        if(stock.getQte()!=0) st.setQte(stock.getQte());

        if(stock.getQtemin()!=0)st.setQtemin(stock.getQtemin());

        stockRepository.save(st);
    }



}
