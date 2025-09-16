package net.escoz.evaluation.presentation.dto.player;

import java.util.List;

public record PlayerOutDTO(
		long id,
		String name,
		String surname,
		int age,
		String email,
		List<String> positions,
		String league,
		String team
) {
}
