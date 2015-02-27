package com.card.service;

import com.card.entity.Card;
import com.card.entity.Discount;
import com.card.repository.CardRepository;
import com.card.service.businessexception.NoDiscountException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class CardServiceTest {

  private static final String NAME = "name";
  public static final String PUB = "Pub";

  @Autowired private CardService cardService;
  @Autowired private CardRepository cardRepository;

  private Card card;

  @Before
  public void setUp() throws Exception {
    cardRepository.deleteAll();

    card = new Card();
    card.setCardNumber("number");
    card.setName(NAME);
    Discount discount = new Discount();
    discount.setPercentage(3);
    discount.setName("Pub");
    card.setDiscounts(Arrays.asList(discount));
  }

  @Test
  public void testPutAndGetCardById() throws Exception {
    cardRepository.save(card);

    Card cardById = cardService.getCardById(1L);

    assertNotNull(cardById);
    assertEquals(NAME, cardById.getName());

    Discount discount = cardById.getDiscounts().get(0);
    assertEquals(PUB, discount.getName());
  }

  @Test
  public void testGetDiscountById() {
    cardRepository.save(card);
    int discountValue = cardService.getDiscountValue(1L, "Pub");
    int expected = card.getDiscounts().get(0).getPercentage();
    assertEquals(expected, discountValue);
  }

  @Test(expected = NoDiscountException.class)
  public void testGetDiscountByIdThrowsException() {
    cardRepository.save(card);
    cardService.getDiscountValue(1L, "Pub2");
  }

}