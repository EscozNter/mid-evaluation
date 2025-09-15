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
}
