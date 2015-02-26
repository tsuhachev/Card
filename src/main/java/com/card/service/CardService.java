package com.card.service;

import com.card.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.card.repository.CardRepository;

/**
 * Card Service
 */
@Component
public class CardService {

  @Autowired
  private CardRepository cardRepository;

  public Card getCardById(Long id) {
    return cardRepository.findOne(id);
  }


}
