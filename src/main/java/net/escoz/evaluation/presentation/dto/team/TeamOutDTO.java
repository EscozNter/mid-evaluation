package net.escoz.evaluation.presentation.dto.team;

import net.escoz.evaluation.presentation.dto.player.PlayerBasicOutDTO;

import java.util.List;

public record TeamOutDTO(
		long id,
		String name,
		String league,
		List<PlayerBasicOutDTO> players
) {
}
