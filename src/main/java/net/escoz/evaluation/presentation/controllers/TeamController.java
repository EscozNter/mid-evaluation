package net.escoz.evaluation.presentation.controllers;

import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.mappers.TeamMapper;
import net.escoz.evaluation.application.services.TeamService;
import net.escoz.evaluation.presentation.dto.team.TeamBasicOutDTO;
import net.escoz.evaluation.presentation.dto.team.TeamOutDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teams")
public class TeamController {

	private final TeamService teamService;
	private final TeamMapper teamMapper;

	@GetMapping
	public ResponseEntity<List<TeamBasicOutDTO>> getTeams() {
		List<TeamBasicOutDTO> response = teamService.getTeams()
				.stream()
				.map(teamMapper::toBasicDTO)
				.toList();

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TeamOutDTO> getLeague(@PathVariable long id) {
		return ResponseEntity
				.ok(teamMapper.toDTO(teamService.getById(id)));
	}
}
