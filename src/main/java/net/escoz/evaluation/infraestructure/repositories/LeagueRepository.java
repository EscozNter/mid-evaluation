package net.escoz.evaluation.infraestructure.repositories;

import net.escoz.evaluation.domain.entities.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

	/**
	 * Checks if there exists a league with the specified name.
	 *
	 * @param name the name of the league to search for
	 * @return true if a league with the specified name exists, false otherwise
	 */
	boolean existsByName(String name);

	/**
	 * Checks if there exists a league with the specified name and an ID that is not equal
	 * to the specified ID.
	 *
	 * @param name the name of the league to search for
	 * @param id   the ID to exclude from the search
	 * @return true if there exists a league with the specified name and a different ID,
	 * false otherwise
	 */
	boolean existsByNameAndIdNot(String name, Long id);
}