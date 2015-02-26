package com.card.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.card.entity.Card;
import com.card.repository.CardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class CardServiceTest {

  private static final String NAME = "name";

  @Autowired private CardService cardService;
  @Autowired private CardRepository cardRepository;

  private Card card;

  @Before
  public void setUp() throws Exception {
    cardRepository.deleteAll();

    card = new Card();
    card.setCardNumber("number");
    card.setName(NAME);
  }

  @Test
  public void testPutAndGetCardById() throws Exception {
    cardRepository.save(card);

    Card cardById = cardService.getCardById(1L);

    assertNotNull(cardById);
    assertEquals(NAME, cardById.getName());
  }
}