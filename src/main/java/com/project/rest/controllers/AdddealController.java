package com.project.rest.controllers;

import com.project.rest.Deal;
import com.project.rest.DealRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdddealController {
    Deal deal[]=new Deal[0];
    @PostMapping("/add_deal")
    public Deal[] Adddeal(@RequestBody DealRequest dealRequest){
        Deal newdeal[]=new Deal[deal.length+1];
        for(int i=0;i<deal.length;i++) {
            newdeal[i] = deal[i];
        }
        newdeal[newdeal.length-1]=new Deal(
                dealRequest.date(),
                dealRequest.type(),
                dealRequest.price(),
                dealRequest.volume(),
                dealRequest.coin_name(),
                dealRequest.coin_code());
        deal=newdeal;
        return deal;
    }
}
