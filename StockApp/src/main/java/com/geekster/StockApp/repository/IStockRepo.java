package com.geekster.StockApp.repository;

import com.geekster.StockApp.model.Stock;
import com.geekster.StockApp.model.StockType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IStockRepo extends CrudRepository<Stock,Long> {


    @Query(value = "select * from stock where stock_id = :id+1",nativeQuery = true)
    List<Stock> findStockId(Long id);




    List<Stock> findByStockTypeOrderByStockPriceDesc(StockType type);

    List<Stock> findFirstByStockName(String name);

    List<Stock> findByStockBirth(LocalDate date);


   // List<Stock> findByStockPrice(Double price);

    List<Stock> findOrderByStockPrice(Double price);

   // List<Stock> findByStockPriceLessThan(Double price);

    List<Stock> findAllByStockPriceLessThan(Double price);
}
