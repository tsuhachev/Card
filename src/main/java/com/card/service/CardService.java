package com.card.service;

import com.card.entity.Card;
import com.card.entity.Discount;
import com.card.repository.DiscountRepository;
import com.card.service.businessexception.NoDiscountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.card.repository.CardRepository;

/**
 * Card Service
 */
@Component
public class CardService {

  @Autowired private CardRepository cardRepository;
  @Autowired private DiscountRepository discountRepository;

  public Card getCardById(Long id) {
    return cardRepository.findOne(id);
  }

  public int getDiscountValue(long cardId, String discountForName) {
    long discountId = discountRepository.findByName(discountForName);

    Card card = cardRepository.findOne(cardId);
    for (Discount discount : card.getDiscounts()) {
      if (discountId == discount.getId()) {
        return discount.getPercentage();
      }
    }
    throw new NoDiscountException("Card does not have such discount");
  }
}
