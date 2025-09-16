package net.escoz.evaluation.presentation.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.mappers.PlayerMapper;
import net.escoz.evaluation.application.services.PlayerService;
import net.escoz.evaluation.domain.entities.Player;
import net.escoz.evaluation.presentation.dto.BasicResponseDTO;
import net.escoz.evaluation.presentation.dto.player.PlayerBasicOutDTO;
import net.escoz.evaluation.presentation.dto.player.PlayerInDTO;
import net.escoz.evaluation.presentation.dto.player.PlayerOutDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping
	public ResponseEntity<PlayerOutDTO> postPlayer(@Valid @RequestBody PlayerInDTO request) {
		Player player = playerMapper.toModel(request);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(playerMapper.toDTO(playerService.createPlayer(player)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicResponseDTO> deletePlayer(@PathVariable long id) {
		playerService.deletePlayer(id);

		return ResponseEntity
				.ok(BasicResponseDTO.builder()
						.status(HttpStatus.OK.value())
						.message("Successfully deleted player with id: " + id)
						.build());
	}
}
