package com.project.rest.controllers;

import com.project.rest.models.*;
import com.project.rest.repository.CoinsRepository;
import com.project.rest.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/portfolio")
public class PortfolioController {
    @Autowired
    private PortfolioRepository portfolioRepository;
    @GetMapping
    public List<Portfolio> getAllPortfolios(){
        return portfolioRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolioByID(@PathVariable Integer id){
        Optional<Portfolio> portfolioOptional=portfolioRepository.findById(id);
        return portfolioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
        Portfolio savedPortfolio = portfolioRepository.save(portfolio);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPortfolio);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable Integer id,@RequestBody Portfolio updatePortfolio){
        Optional<Portfolio> portfolioOptional = portfolioRepository.findById(id);
        if(portfolioOptional.isPresent()){
            updatePortfolio.setid(id);
            Portfolio savedPortfolio=portfolioRepository.save(updatePortfolio);
            return ResponseEntity.ok(savedPortfolio);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Integer id) {
        Optional<Portfolio> PortfolioOptional = portfolioRepository.findById(id);
        if (PortfolioOptional.isPresent()) {
            portfolioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
