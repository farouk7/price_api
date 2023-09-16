package com.price.price_api.service;

import com.price.price_api.dao.Price;
import com.price.price_api.repository.PriceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price findApplicablePrice(Long brandId, Long productId, Date date) {
        List<Price> applicablePrices = priceRepository
                .findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                        brandId, productId, date, date);

        if (!applicablePrices.isEmpty()) {
            return applicablePrices.get(0); // Devuelve el precio con mayor prioridad
        }

        return null; // No se encontró ningún precio aplicable
    }
    public List<Price> findAllBrand() {
        return priceRepository.findAll();
    }
}