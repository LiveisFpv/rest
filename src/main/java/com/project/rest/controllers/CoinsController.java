package com.project.rest.controllers;

import com.project.rest.models.Coin;
import com.project.rest.models.Coins;
import com.project.rest.models.Deal;
import com.project.rest.repository.CoinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coins")
public class CoinsController {
    @Autowired
    private CoinsRepository coinsRepository;
    @GetMapping
    public List<Coins> getAllCoins(){
        return coinsRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Coins> getCoinByID(@PathVariable Integer id){
        Optional<Coins>coinsOptional=coinsRepository.findById(id);
        return coinsOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Coins> createCoin(@RequestBody Coins coin) {
        Coins savedCoin = coinsRepository.save(coin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCoin);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Coins> updateCoin(@PathVariable Integer id,@RequestBody Coins updateCoin){
        Optional<Coins> coinsOptional = coinsRepository.findById(id);
        if(coinsOptional.isPresent()){
            updateCoin.setid(id);
            Coins savedCoin=coinsRepository.save(updateCoin);
            return ResponseEntity.ok(savedCoin);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoin(@PathVariable Integer id) {
        Optional<Coins> coinsOptional = coinsRepository.findById(id);
        if (coinsOptional.isPresent()) {
            coinsRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
