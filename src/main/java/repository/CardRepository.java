package repository;

import org.springframework.data.repository.CrudRepository;

import javax.smartcardio.Card;

/**
 * Describes repository for Card ertity
 */
public interface CardRepository extends CrudRepository<Card, Long> {
}
