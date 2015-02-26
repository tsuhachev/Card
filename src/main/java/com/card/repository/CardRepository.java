package com.card.repository;

import com.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Describes com.card.repository for Card entity
 */
public interface CardRepository extends JpaRepository<Card, Long> {
}
