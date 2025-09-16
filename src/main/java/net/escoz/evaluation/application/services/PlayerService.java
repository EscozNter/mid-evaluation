package net.escoz.evaluation.application.services;

import net.escoz.evaluation.domain.entities.Player;
import net.escoz.evaluation.exceptions.NotFoundException;

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
	 * Deletes a Player entity by its unique identifier.
	 *
	 * @param id the unique identifier of the Player to be deleted
	 * @throws NotFoundException if no Player is found with the provided id
	 */
	void deletePlayer(long id);
}
