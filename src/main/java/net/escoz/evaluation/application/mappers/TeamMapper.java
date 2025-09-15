package net.escoz.evaluation.application.mappers;

import net.escoz.evaluation.domain.entities.Player;
import net.escoz.evaluation.domain.entities.Team;
import net.escoz.evaluation.presentation.dto.team.TeamBasicOutDTO;
import net.escoz.evaluation.presentation.dto.team.TeamOutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(
		componentModel = "spring",
		uses = {PlayerMapper.class}
)
public interface TeamMapper {

	@Mapping(target = "league", source = "league.name")
	TeamOutDTO toDTO(Team team);

	@Mapping(target = "league", source = "league.name")
	@Mapping(target = "nPlayers", source = "players")
	TeamBasicOutDTO toBasicDTO(Team team);

	default int mapToPlayers(Set<Player> players) {
		return players.size();
	}
}
