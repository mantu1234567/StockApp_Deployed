package com.geekster.StockApp.controller;

import com.geekster.StockApp.model.Stock;
import com.geekster.StockApp.model.StockType;
import com.geekster.StockApp.service.StockService;
import jakarta.persistence.Id;
import org.hibernate.loader.ast.spi.Loadable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;
    // get all Stock
    @GetMapping("get/all")
    public Iterable<Stock> getAllStock(){
        return stockService.getAll();
    }
    //add all data
    @PostMapping("add/all")
    public String addAllStock(@RequestBody List<Stock> stockList){
       return stockService.addAllStock(stockList);
    }
    // find by id
    @GetMapping("find/id/{Id}")
    public List<Stock> findById(@PathVariable Long Id){
        return stockService.findById(Id);
    }
    @DeleteMapping("delete/id/{Id}")
    public void deleteId(@PathVariable Long Id){

        stockService.deleteId(Id);
    }

    @GetMapping("stock/type/{type}")
    public List<Stock> getStockByType(@PathVariable StockType type){
        return stockService.getStockByType(type);
    }
    @GetMapping("first/name/{name}")
    public List<Stock> findFirstName(@PathVariable String name){
        return stockService.findFirstName(name);
    }
     @GetMapping("birt/time/{date}")
    public List<Stock> getByBirthTime(@PathVariable LocalDate date){
        return stockService.getByBirthTime(date);
    }
     @GetMapping("orderBy/price/{price}")
    public List<Stock> orderByPrice(@PathVariable Double price){
        return stockService.orderByPrice(price);
    }
    @GetMapping("price/less/{price}")
    public List<Stock> stockPriceLessThan(@PathVariable Double price){
        return stockService.stockPriceLessThan(price);
    }
}

