package net.escoz.evaluation.application.services;

import net.escoz.evaluation.domain.entities.League;
import net.escoz.evaluation.exceptions.NotFoundException;

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
	League getById(Long id);

}
