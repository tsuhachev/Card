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
  @Autowired
  private CardService cardService;

  @Autowired
  private CardRepository cardRepository;

  @Before
  public void setUp() throws Exception {
    cardRepository.deleteAll();

    Card card = new Card();
    card.setCardNumber("number");
    card.setName(NAME);
    cardRepository.save(card);
  }

  @Test
  public void testGetCardById() throws Exception {
    Card cardById = cardService.getCardById((long) 1);
    assertNotNull(cardById);
    assertEquals(NAME, cardById.getName());
  }
}