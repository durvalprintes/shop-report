package com.casa.codigo.controller;

import com.casa.codigo.model.ShopReport;
import com.casa.codigo.repository.ShopReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ShopReportController {

    private final ShopReportRepository repository;

    @GetMapping
    public List<ShopReport> getStatusShop() {
        return repository.findAll();
    }

}
