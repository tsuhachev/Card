-- table structure

CREATE TABLE card
(
  id         INT,
  name       VARCHAR(255),
  cardNumber VARCHAR(255),
  ownerId    INT
);

CREATE TABLE discount
(
  id         INT,
  name       VARCHAR(255),
  percentage INT
);

-- CREATE TABLE business
-- (
--   id   INT,
--   name VARCHAR(255)
-- );

CREATE TABLE card_discount (
  card_id     INT,
  discount_id INT,
  PRIMARY KEY (card_id, discount_id),
  FOREIGN KEY (card_id) REFERENCES card (id),
  FOREIGN KEY (discount_id) REFERENCES discount (id)
);

CREATE TABLE owner
(
  id       INT,
  username VARCHAR(255),
  phone    VARCHAR(255)
);

CREATE SEQUENCE hibernate_sequence;