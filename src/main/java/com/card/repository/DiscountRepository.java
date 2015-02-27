package com.card.repository;

import com.card.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Describes com.card.repository for Card entity
 */
public interface DiscountRepository extends JpaRepository<Discount, Long> {

  @Query(value = "select d.id from Discount d where d.name = :discountName")
  long findByName(@Param("discountName") String discountForName);
}
