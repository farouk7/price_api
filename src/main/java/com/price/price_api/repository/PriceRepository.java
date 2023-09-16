package com.price.price_api.repository;

import com.price.price_api.dao.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Long brandId, Long productId, Date date, Date date2);

}