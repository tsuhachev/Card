package com.card.service;

import com.card.entity.Card;
import com.card.entity.Discount;
import com.card.entity.Owner;
import com.card.repository.CardRepository;
import com.card.repository.DiscountRepository;
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
  public static final String SOME_OWNER = "someOwner";

  @Autowired private CardService cardService;
  @Autowired private CardRepository cardRepository;
  @Autowired private DiscountRepository discountRepository;

  private Card savedCard;

  @Before
  public void setUp() throws Exception {
    cardRepository.deleteAll();
    discountRepository.deleteAll();

    Card card = new Card();
    card.setCardNumber("number");
    card.setName(NAME);
    Discount discount = new Discount();
    discount.setPercentage(3);
    discount.setName("Pub");
    card.setDiscounts(Arrays.asList(discount));
    Owner owner = new Owner();
    owner.setUsername(SOME_OWNER);
    owner.setPhone("145254242");
    card.setOwner(owner);
    savedCard = cardRepository.save(card);
  }

  @Test
  public void testPutAndGetCardById() throws Exception {

    Card cardById = cardService.getCardById(savedCard.getId());

    assertNotNull(cardById);
    assertEquals(NAME, cardById.getName());

    Discount discount = cardById.getDiscounts().get(0);
    assertEquals(PUB, discount.getName());
  }

  @Test
  public void testGetDiscountById() {
    int discountValue = cardService.getDiscountValue(savedCard.getId(), savedCard.getDiscounts().get(0).getId());
    int expected = savedCard.getDiscounts().get(0).getPercentage();
    assertEquals(expected, discountValue);
  }

  @Test(expected = NoDiscountException.class)
  public void testGetDiscountByIdThrowsException() {
    cardService.getDiscountValue(savedCard.getId(), 1234L);
  }

  @Test
  public void testGetUserDetails() {
    Card cardById = cardService.getCardById(savedCard.getId());
    Owner owner = cardById.getOwner();
    assertEquals(SOME_OWNER, owner.getUsername());
  }
}