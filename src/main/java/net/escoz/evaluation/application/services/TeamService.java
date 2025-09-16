package net.escoz.evaluation.application.services;

import net.escoz.evaluation.domain.entities.Team;
import net.escoz.evaluation.exceptions.NotFoundException;
import net.escoz.evaluation.exceptions.UnprocessableEntityException;

import java.util.List;

public interface TeamService {

	/**
	 * Retrieves a list of all teams from the data repository
	 */
	List<Team> getTeams();

	/**
	 * Retrieves a Team by its unique identifier.
	 *
	 * @param id the unique identifier of the Team to retrieve
	 * @return the Team entity associated with the given id
	 * @throws NotFoundException if no Team is found with the provided id
	 */
	Team getById(long id);

	/**
	 * Creates a new Team and saves it to the repository.
	 *
	 * @param team the Team entity to be created and persisted
	 * @return the persisted Team entity
	 */
	Team createTeam(Team team);

	/**
	 * Updates an existing Team entity with the provided details. Ensures that a Team with the
	 * same name but a different ID does not already exist before updating. Throws an exception
	 * if such a Team is found.
	 *
	 * @param team the Team entity containing the updated details
	 * @return the updated Team entity persisted in the repository
	 * @throws UnprocessableEntityException if a Team with the same name but a different ID exists
	 */
	Team updateTeam(Team team);

	/**
	 * Deletes a Team entity by its unique identifier. Ensures that the Team
	 * does not contain any associated Players before deletion. If the Team contains
	 * Players, an exception is thrown.
	 *
	 * @param id the unique identifier of the Team to be deleted
	 * @throws NotFoundException            if no Team is found with the provided id
	 * @throws UnprocessableEntityException if the Team contains associated Teams
	 */
	void deleteTeam(long id);
}
