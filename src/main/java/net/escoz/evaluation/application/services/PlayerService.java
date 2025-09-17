package net.escoz.evaluation.application.services;

import net.escoz.evaluation.domain.entities.Player;
import net.escoz.evaluation.exceptions.NotFoundException;
import net.escoz.evaluation.exceptions.UnprocessableEntityException;

import java.util.List;

public interface PlayerService {

	/**
	 * Retrieves a list of all teams from the data repository
	 */
	List<Player> getPlayers();

	/**
	 * Retrieves a Player by its unique identifier.
	 *
	 * @param id the unique identifier of the Player to retrieve
	 * @return the Player entity associated with the given id
	 * @throws NotFoundException if no Player is found with the provided id
	 */
	Player getById(long id);

	/**
	 * Creates a new Player and saves it to the repository.
	 *
	 * @param player the Player entity to be created and persisted
	 * @return the persisted Player entity
	 */
	Player createPlayer(Player player);

	/**
	 * Updates an existing Player entity with the provided details. Ensures that a Player with the
	 * same email but a different ID does not already exist before updating. Throws an exception
	 * if such a Player is found.
	 *
	 * @param player the Player entity containing the updated details
	 * @return the updated Player entity persisted in the repository
	 * @throws UnprocessableEntityException if a Player with the same email but a different ID exists
	 */
	Player updatePlayer(Player player);

	/**
	 * Deletes a Player entity by its unique identifier.
	 *
	 * @param id the unique identifier of the Player to be deleted
	 * @throws NotFoundException if no Player is found with the provided id
	 */
	void deletePlayer(long id);
}
