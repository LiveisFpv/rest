package com.project.rest.controllers;

import com.project.rest.models.Coin;
import com.project.rest.models.Coins;
import com.project.rest.models.Deal;
import com.project.rest.repository.CoinRepository;
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
@RequestMapping("/api/coin")
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;
    @Autowired
    private PortfolioRepository portfolioRepository;

    @GetMapping
    public List<Coin> getAllCoin() {
        return coinRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coin> getCoinByID(@PathVariable Integer id){
        Optional<Coin>coinOptional=coinRepository.findById(id);
        return coinOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/portfolio/{portfolioId}")
    public ResponseEntity<Coin> addcoin(@PathVariable(value = "portfolioId") Integer Id,
                                              @RequestBody Coin coinRequest) {
        Coin coin = portfolioRepository.findById(Id).map(portfolio -> {
            coinRequest.setPortfolio(portfolio);
            return coinRepository.save(coinRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Portfolio with id = " + Id));

        return new ResponseEntity<>(coin, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoin(@PathVariable Integer id) {
        Optional<Coin> coinsOptional = coinRepository.findById(id);
        if (coinsOptional.isPresent()) {
            coinRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
