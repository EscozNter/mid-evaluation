package net.escoz.evaluation.presentation.dto.team;

import lombok.Builder;

@Builder
public record TeamBasicOutDTO(
		long id,
		String name,
		String league,
		int nPlayers
) {
}
