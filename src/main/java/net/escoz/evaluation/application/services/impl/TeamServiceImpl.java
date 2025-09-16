package net.escoz.evaluation.application.services.impl;

import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.mappers.TeamMapper;
import net.escoz.evaluation.application.services.TeamService;
import net.escoz.evaluation.domain.entities.Team;
import net.escoz.evaluation.exceptions.NotFoundException;
import net.escoz.evaluation.exceptions.UnprocessableEntityException;
import net.escoz.evaluation.infraestructure.repositories.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;
	private final TeamMapper teamMapper;

	@Override
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}

	@Override
	public Team getById(long id) {
		return teamRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Team not found with id " + id));
	}

	@Override
	@Transactional
	public Team createTeam(Team team) {
		if (teamRepository.existsByName(team.getName()))
			throw new UnprocessableEntityException("Team name already exists: " + team.getName());

		return teamRepository.save(team);
	}

	@Override
	@Transactional
	public Team updateTeam(Team team) {
		if (teamRepository.existsByNameAndIdNot(team.getName(), team.getId()))
			throw new UnprocessableEntityException("Team with name " + team.getName() + " already exists");

		return teamRepository.save(
				teamMapper.updateTeam(team, getById(team.getId()))
		);
	}

	@Override
	@Transactional
	public void deleteTeam(long id) {
		Team team = getById(id);

		if (!team.getPlayers().isEmpty())
			throw new UnprocessableEntityException("Team with id: " + id + " has players");

		teamRepository.delete(team);
	}
}
