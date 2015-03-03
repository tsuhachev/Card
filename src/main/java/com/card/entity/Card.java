package com.card.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Card Entity
 */
@Entity
@Table(name = "card")
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private String cardNumber;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "card_discount",
      joinColumns = @JoinColumn(name = "card_id"),
      inverseJoinColumns = @JoinColumn(name = "discount_id"))
  private List<Discount> discounts;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "ownerId")
  private Owner owner;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public List<Discount> getDiscounts() {
    return discounts;
  }

  public void setDiscounts(List<Discount> discounts) {
    this.discounts = discounts;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }
}
