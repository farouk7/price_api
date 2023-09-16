package com.price.price_api.dao;


import jakarta.persistence.*;


import java.util.Date;

@Entity

public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long brandId;
    private Date startDate;
    private Date endDate;
    private Long priceList;
    private Long productId;
    private Long priority;
    private Double price;

    private String curr;

    public void setBrandId(long l) {
        brandId = l;
    }

    public void setProductId(long l) {
        productId = l;
    }

    public void setStartDate(Date date) {
        startDate = date;
    }

    public void setEndDate(Date date) {
        endDate = date;
    }

    public void setPriceList(long l) {
        priceList = l;
    }

    public void setPriority(long l) {
        priority = l;
    }

    public void setPrice(double v) {
        price = v;
    }

    public void setCurrency(String eur) {
        curr= eur;
    }

    // Getters y setters

    public Long getBrandId() {
        return brandId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getPriority() {
        return priority;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return curr;
    }
}