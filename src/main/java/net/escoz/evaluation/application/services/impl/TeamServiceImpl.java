package net.escoz.evaluation.application.services.impl;

import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.services.TeamService;
import net.escoz.evaluation.domain.entities.Team;
import net.escoz.evaluation.exceptions.NotFoundException;
import net.escoz.evaluation.infraestructure.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;

	@Override
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}

	@Override
	public Team getById(long id) {
		return teamRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Team not found with id " + id));
	}
}
