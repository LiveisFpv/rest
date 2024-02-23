package com.project.rest.controllers;

import com.project.rest.Deal;
import com.project.rest.DealRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdddealController {
    Deal deal;
    @PostMapping("/add_deal")
    @ResponseStatus(HttpStatus.OK)
    public void Adddeal(DealRequest dealRequest){
        deal=new Deal(
                dealRequest.date(),
                dealRequest.type(),
                dealRequest.price(),
                dealRequest.volume(),
                dealRequest.coin_name(),
                dealRequest.coin_code());
    }
    /*@RequestMapping("/adddeal")
    public Deal greeting(){
        return deal;
    }
     */
}
