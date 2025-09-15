package net.escoz.evaluation.presentation.controllers;

import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.mappers.PlayerMapper;
import net.escoz.evaluation.application.services.PlayerService;
import net.escoz.evaluation.presentation.dto.player.PlayerBasicOutDTO;
import net.escoz.evaluation.presentation.dto.player.PlayerOutDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/players")
public class PlayerController {

	private final PlayerService playerService;
	private final PlayerMapper playerMapper;

	@GetMapping
	public ResponseEntity<List<PlayerBasicOutDTO>> getPlayers() {
		List<PlayerBasicOutDTO> response = playerService.getPlayers()
				.stream()
				.map(playerMapper::toBasicDTO)
				.toList();

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PlayerOutDTO> getPlayer(@PathVariable long id) {
		return ResponseEntity
				.ok(playerMapper.toDTO(playerService.getById(id)));
	}
}
