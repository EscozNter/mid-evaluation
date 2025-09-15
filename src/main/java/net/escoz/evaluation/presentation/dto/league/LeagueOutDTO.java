package net.escoz.evaluation.presentation.dto.league;

import com.fasterxml.jackson.annotation.JsonInclude;
import net.escoz.evaluation.presentation.dto.team.TeamBasicOutDTO;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LeagueOutDTO(
		long id,
		String name,
		String description,
		boolean active,
		List<TeamBasicOutDTO> teams
) {
}
