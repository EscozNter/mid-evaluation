package net.escoz.evaluation.presentation.dto.league;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class LeagueInDTO {

	@NotBlank(message = "Name cannot be null or empty")
	private String name;

	private String description;

	private Boolean active;
}
