package net.escoz.evaluation.application.services.impl;

import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.services.LeagueService;
import net.escoz.evaluation.domain.entities.League;
import net.escoz.evaluation.exceptions.NotFoundException;
import net.escoz.evaluation.exceptions.UnprocessableEntityException;
import net.escoz.evaluation.infraestructure.repositories.LeagueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService {

	private final LeagueRepository leagueRepository;

	@Override
	public List<League> getLeagues() {
		return leagueRepository.findAll();
	}

	@Override
	public League getById(long id) {
		return leagueRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("League not found with id: " + id));
	}

	@Override
	@Transactional
	public League createLeague(League league) {
		return leagueRepository.save(league);
	}

	@Override
	@Transactional
	public void deleteLeague(long id) {
		League league = getById(id);

		if (!league.getTeams().isEmpty())
			throw new UnprocessableEntityException("League with id: " + id + " has teams");

		leagueRepository.delete(league);
	}
}
