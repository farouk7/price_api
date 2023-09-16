package com.price.price_api.controller;

import com.price.price_api.dao.Price;
import com.price.price_api.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
//@RequestMapping("/")
public class PriceController {
    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/getPrice")
    public Price getPrice(@RequestParam Long brandId, @RequestParam Long productId,
                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        return priceService.findApplicablePrice(brandId, productId, date);
    }
    @GetMapping("/getPriceAll")
    public List<Price> getPrice(){//@RequestParam Long brandId) {
        return priceService.findAllBrand();
    }
}