package net.escoz.evaluation.infraestructure.repositories;

import net.escoz.evaluation.domain.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	/**
	 * Checks if there exists a player with the specified email.
	 *
	 * @param email the email of the player to search for
	 * @return true if a player with the specified email exists, false otherwise
	 */
	boolean existsByEmail(String email);

	/**
	 * Checks if there exists a player with the specified email and an ID that is not equal
	 * to the specified ID.
	 *
	 * @param email the email of the player to search for
	 * @param id    the ID to exclude from the search
	 * @return true if a player with the specified email and a different ID exists,
	 * false otherwise
	 */
	boolean existsByEmailAndIdNot(String email, long id);
}