package net.escoz.evaluation.application.services.impl;

import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.services.LeagueService;
import net.escoz.evaluation.domain.entities.League;
import net.escoz.evaluation.exceptions.NotFoundException;
import net.escoz.evaluation.infraestructure.repositories.LeagueRepository;
import org.springframework.stereotype.Service;

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
}
