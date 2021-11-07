package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dtos.SaleDTO;
import com.devsuperior.dsvendas.dtos.SaleSumDTO;
import com.devsuperior.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> sales = saleService.findAll(pageable);
        return ResponseEntity.ok(sales);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> salesGroupedBySeller = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(salesGroupedBySeller);
    }
}
