package net.escoz.evaluation.application.services;

import net.escoz.evaluation.domain.entities.League;
import net.escoz.evaluation.exceptions.NotFoundException;
import net.escoz.evaluation.exceptions.UnprocessableEntityException;

import java.util.List;

public interface LeagueService {

	/**
	 * Retrieves a list of all leagues from the data repository
	 */
	List<League> getLeagues();

	/**
	 * Retrieves a League by its unique identifier.
	 *
	 * @param id the unique identifier of the League to retrieve
	 * @return the League entity associated with the given id
	 * @throws NotFoundException if no League is found with the provided id
	 */
	League getById(long id);

	/**
	 * Creates a new League and saves it to the repository.
	 *
	 * @param league the League entity to be created and persisted
	 * @return the persisted League entity
	 */
	League createLeague(League league);

	/**
	 * Updates an existing League entity with the provided details. Ensures that a League with the
	 * same name but a different ID does not already exist before updating. Throws an exception
	 * if such a League is found.
	 *
	 * @param league the League entity containing the updated details
	 * @return the updated League entity persisted in the repository
	 * @throws UnprocessableEntityException if a League with the same name but a different ID exists
	 */
	League updateLeague(League league);

	/**
	 * Deletes a League entity by its unique identifier. Ensures that the League
	 * does not contain any associated Teams before deletion. If the League contains
	 * Teams, an exception is thrown.
	 *
	 * @param id the unique identifier of the League to be deleted
	 * @throws NotFoundException            if no League is found with the provided id
	 * @throws UnprocessableEntityException if the League contains associated Teams
	 */
	void deleteLeague(long id);
}
