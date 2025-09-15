package net.escoz.evaluation.presentation.controllers;

import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.mappers.LeagueMapper;
import net.escoz.evaluation.application.services.LeagueService;
import net.escoz.evaluation.presentation.dto.league.LeagueOutDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
