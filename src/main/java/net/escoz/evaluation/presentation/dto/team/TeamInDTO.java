package net.escoz.evaluation.presentation.dto.team;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class TeamInDTO {

	@NotBlank(message = "Name cannot be null or empty")
	private String name;

	private long leagueId;
}
