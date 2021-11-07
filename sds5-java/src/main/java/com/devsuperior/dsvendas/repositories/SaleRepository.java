package com.devsuperior.dsvendas.repositories;

import com.devsuperior.dsvendas.dtos.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsvendas.dtos.SaleSumDTO(sale.seller, SUM(sale.amount)) " +
            "FROM Sale as sale GROUP BY sale.seller")
    List<SaleSumDTO> amountGroupedBySeller();
}
