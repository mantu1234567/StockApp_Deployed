package com.geekster.StockApp.service;

import com.geekster.StockApp.model.Stock;
import com.geekster.StockApp.model.StockType;
import com.geekster.StockApp.repository.IStockRepo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService {
    @Autowired
    IStockRepo iStockRepo;

    public String addAllStock(List<Stock> stockList) {
        iStockRepo.saveAll(stockList);
        return "create stock App";
    }

    public Iterable<Stock> getAll() {
        return iStockRepo.findAll();
    }

    public List<Stock> findById(Long id) {

        return iStockRepo.findStockId(id);
    }

    public void deleteId(Long id) {
        iStockRepo.deleteById(id);
    }

    public List<Stock> getStockByType(StockType type) {
        return iStockRepo.findByStockTypeOrderByStockPriceDesc(type);
    }

    public List<Stock> findFirstName(String name) {
        return iStockRepo.findFirstByStockName(name);
    }

    public List<Stock> getByBirthTime(LocalDate date) {
        return iStockRepo.findByStockBirth(date);
    }

    public List<Stock> orderByPrice(Double price) {
        return iStockRepo.findOrderByStockPrice(price);
    }


    public List<Stock> stockPriceLessThan(Double price) {
        return iStockRepo.findAllByStockPriceLessThan(price);
    }
}
