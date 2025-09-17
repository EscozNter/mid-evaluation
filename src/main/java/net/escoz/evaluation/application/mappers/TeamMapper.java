package net.escoz.evaluation.application.mappers;

import net.escoz.evaluation.application.services.LeagueService;
import net.escoz.evaluation.domain.entities.Player;
import net.escoz.evaluation.domain.entities.Team;
import net.escoz.evaluation.presentation.dto.team.TeamBasicOutDTO;
import net.escoz.evaluation.presentation.dto.team.TeamInDTO;
import net.escoz.evaluation.presentation.dto.team.TeamOutDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper(
		componentModel = "spring",
		uses = {
				PlayerMapper.class,
				LeagueService.class
		}
)
public interface TeamMapper {

	@Mapping(target = "league", source = "league.name")
	TeamOutDTO toDTO(Team team);

	@Mapping(target = "league", source = "league.name")
	@Mapping(target = "nPlayers", source = "players")
	TeamBasicOutDTO toBasicDTO(Team team);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "players", ignore = true)
	@Mapping(target = "league", source = "leagueId")
	Team toModel(TeamInDTO teamInDTO);

	@Mapping(target = "players", ignore = true)
	@Mapping(target = "league", source = "teamInDTO.leagueId")
	Team toModelWithId(TeamInDTO teamInDTO, long id);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "players", ignore = true)
	// updateTeam ignora league para evitar que MapStruct lo resuelva con LeagueService
	// es una guarrada, pero me da pereza hacer las cosas bien :) asi que lo hacemos a mano.
	@Mapping(target = "league", ignore = true)
	Team updateTeam(Team source, @MappingTarget Team target);

	@AfterMapping
	default void updateLeague(Team source, @MappingTarget Team target) {
		if (!source.getLeague().equals(target.getLeague()))
			target.setLeague(source.getLeague());
	}

	default int mapToPlayers(Set<Player> players) {
		return players.size();
	}
}
