package com.card.service;

import com.card.entity.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class CardServiceTest {

  @Autowired
  private CardService cardService;

  @Test
  public void testGetCardById() throws Exception {
    Card cardById = cardService.getCardById((long) 1);
    assertNotNull(cardById);
  }
}