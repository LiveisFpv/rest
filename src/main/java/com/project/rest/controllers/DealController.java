package com.project.rest.controllers;

import com.project.rest.models.Coins;
import com.project.rest.models.Deal;
import com.project.rest.DealRequest;
import com.project.rest.repository.DealRepository;
import com.project.rest.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deals")
public class DealController {
    @Autowired
    private DealRepository dealRepository;
    @Autowired
    private PortfolioRepository portfolioRepository;

    // Получение всех сделок
    @GetMapping
    public List<Deal> getAllDeals() {
        return dealRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Deal> getDealByID(@PathVariable Integer id){
        Optional<Deal>dealOptional=dealRepository.findById(id);
        return dealOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Добавление новой сделки
    @PostMapping("/portfolio/{portfolioId}")
    public ResponseEntity<Deal> createComment(@PathVariable(value = "portfolioId") Integer Id,
                                                 @RequestBody Deal dealRequest) {
        Deal deal = portfolioRepository.findById(Id).map(portfolio -> {
            dealRequest.setPortfolio(portfolio);
            return dealRepository.save(dealRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Portfolio with id = " + Id));

        return new ResponseEntity<>(deal, HttpStatus.CREATED);
    }

    // Удаление сделки по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeal(@PathVariable Integer id) {
        Optional<Deal> dealOptional = dealRepository.findById(id);
        if (dealOptional.isPresent()) {
            dealRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
