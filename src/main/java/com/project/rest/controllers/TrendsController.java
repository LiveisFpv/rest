package com.project.rest.controllers;

import com.project.rest.models.Coins;
import com.project.rest.models.Trend;
import com.project.rest.repository.CoinsRepository;
import com.project.rest.repository.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trends")
public class TrendsController {

    @Autowired
    private TrendRepository trendRepository;
    @GetMapping
    public List<Trend> getAllTrend(){
        return trendRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Trend> getTrendByID(@PathVariable Integer id){
        Optional<Trend> trendOptional=trendRepository.findById(id);
        return trendOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Trend> createTrend(@RequestBody Trend trend) {
        Trend savedCoin = trendRepository.save(trend);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCoin);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Trend> updateTrend(@PathVariable Integer id,@RequestBody Trend updateTrend){
        Optional<Trend> trendOptional = trendRepository.findById(id);
        if(trendOptional.isPresent()){
            updateTrend.setid(id);
            Trend savedTrend=trendRepository.save(updateTrend);
            return ResponseEntity.ok(savedTrend);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrend(@PathVariable Integer id) {
        Optional<Trend> TrendOptional = trendRepository.findById(id);
        if (TrendOptional.isPresent()) {
            trendRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
