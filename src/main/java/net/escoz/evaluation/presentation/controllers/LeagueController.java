package net.escoz.evaluation.presentation.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.mappers.LeagueMapper;
import net.escoz.evaluation.application.services.LeagueService;
import net.escoz.evaluation.domain.entities.League;
import net.escoz.evaluation.presentation.dto.BasicResponseDTO;
import net.escoz.evaluation.presentation.dto.league.LeagueInDTO;
import net.escoz.evaluation.presentation.dto.league.LeagueOutDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/leagues")
public class LeagueController {

	private final LeagueService leagueService;
	private final LeagueMapper leagueMapper;

	@GetMapping
	public ResponseEntity<List<LeagueOutDTO>> getLeagues() {
		List<LeagueOutDTO> response = leagueService.getLeagues()
				.stream()
				.map(leagueMapper::toBasicDTO)
				.toList();

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LeagueOutDTO> getLeague(@PathVariable long id) {
		return ResponseEntity
				.ok(leagueMapper.toDTO(leagueService.getById(id)));
	}

	@PostMapping
	public ResponseEntity<LeagueOutDTO> postLeague(@Valid @RequestBody LeagueInDTO request) {
		League league = leagueMapper.toModel(request);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(leagueMapper.toDTO(leagueService.createLeague(league)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicResponseDTO> deleteLeague(@PathVariable long id) {
		leagueService.deleteLeague(id);

		return ResponseEntity
				.ok(BasicResponseDTO.builder()
						.status(HttpStatus.OK.value())
						.message("Successfully deleted league with id: " + id)
						.build());
	}
}
