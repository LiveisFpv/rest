package com.project.rest.controllers;

import com.project.rest.models.Exchanges;
import com.project.rest.models.Exchanges;
import com.project.rest.repository.ExchangesRepository;
import com.project.rest.repository.ExchangesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exchanges")
public class ExchangesController {
    @Autowired
    private ExchangesRepository exchangesRepository;
    @GetMapping
    public List<Exchanges> getAllExchanges(){
        return exchangesRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Exchanges> getExchangesByID(@PathVariable Integer id){
        Optional<Exchanges> exchangesOptional=exchangesRepository.findById(id);
        return exchangesOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Exchanges> createExchanges(@RequestBody Exchanges exchanges) {
        Exchanges savedCoin = exchangesRepository.save(exchanges);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCoin);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Exchanges> updateExchanges(@PathVariable Integer id,@RequestBody Exchanges updateExchanges){
        Optional<Exchanges> ExchangesOptional = exchangesRepository.findById(id);
        if(ExchangesOptional.isPresent()){
            updateExchanges.setid(id);
            Exchanges savedExchanges=exchangesRepository.save(updateExchanges);
            return ResponseEntity.ok(savedExchanges);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
