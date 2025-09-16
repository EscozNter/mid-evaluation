package net.escoz.evaluation.application.mappers;

import net.escoz.evaluation.domain.entities.League;
import net.escoz.evaluation.presentation.dto.league.LeagueInDTO;
import net.escoz.evaluation.presentation.dto.league.LeagueOutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
		componentModel = "spring",
		uses = {TeamMapper.class}
)
public interface LeagueMapper {

	LeagueOutDTO toDTO(League league);

	@Mapping(target = "teams", ignore = true)
	LeagueOutDTO toBasicDTO(League league);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "teams", ignore = true)
	@Mapping(target = "active", defaultValue = "false")
	League toModel(LeagueInDTO leagueInDTO);

	@Mapping(target = "teams", ignore = true)
	League toModelWithId(LeagueInDTO leagueInDTO, long id);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "teams", ignore = true)
	League updateLeague(League source, @MappingTarget League destination);
}
