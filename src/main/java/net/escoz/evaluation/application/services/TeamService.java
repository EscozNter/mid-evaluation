package net.escoz.evaluation.application.services;

import net.escoz.evaluation.domain.entities.Team;
import net.escoz.evaluation.exceptions.NotFoundException;

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
}
