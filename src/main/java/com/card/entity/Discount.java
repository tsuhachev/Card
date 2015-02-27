package com.card.entity;

import javax.persistence.*;

/**
 * Card Entity
 */
@Entity
@Table(name="discount")
public class Discount {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Basic(fetch=FetchType.LAZY)
  private String name;

  @Basic(fetch=FetchType.LAZY)
  private int percentage;

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

  public int getPercentage() {
    return percentage;
  }

  public void setPercentage(int percentage) {
    this.percentage = percentage;
  }

}


