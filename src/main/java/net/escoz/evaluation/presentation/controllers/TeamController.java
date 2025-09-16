package net.escoz.evaluation.presentation.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.mappers.TeamMapper;
import net.escoz.evaluation.application.services.TeamService;
import net.escoz.evaluation.domain.entities.Team;
import net.escoz.evaluation.presentation.dto.BasicResponseDTO;
import net.escoz.evaluation.presentation.dto.team.TeamBasicOutDTO;
import net.escoz.evaluation.presentation.dto.team.TeamInDTO;
import net.escoz.evaluation.presentation.dto.team.TeamOutDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<TeamOutDTO> getTeam(@PathVariable long id) {
		return ResponseEntity
				.ok(teamMapper.toDTO(teamService.getById(id)));
	}

	@PostMapping
	public ResponseEntity<TeamOutDTO> postTeam(@Valid @RequestBody TeamInDTO request) {
		Team team = teamMapper.toModel(request);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(teamMapper.toDTO(teamService.createTeam(team)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TeamOutDTO> updateTeam(@PathVariable long id,
	                                               @Valid @RequestBody TeamInDTO request) {

		Team team = teamMapper.toModelWithId(request, id);

		return ResponseEntity
				.ok(teamMapper.toDTO(teamService.updateTeam(team)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicResponseDTO> deleteTeam(@PathVariable long id) {
		teamService.deleteTeam(id);

		return ResponseEntity
				.ok(BasicResponseDTO.builder()
						.status(HttpStatus.OK.value())
						.message("Successfully deleted team with id: " + id)
						.build());
	}
}
