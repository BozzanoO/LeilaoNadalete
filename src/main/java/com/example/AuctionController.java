package com.example;

import io.micronaut.http.annotation.*;

@Controller("/auction")
public class AuctionController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}