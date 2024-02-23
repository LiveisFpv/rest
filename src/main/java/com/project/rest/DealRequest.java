package com.project.rest;


public record DealRequest(

        String date,

        String type,

        double price,

        double volume,

        String coin_name,

        String coin_code
) {
}
