package net.escoz.evaluation.application.mappers;

import net.escoz.evaluation.domain.entities.League;
import net.escoz.evaluation.presentation.dto.league.LeagueOutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
		componentModel = "spring",
		uses = {TeamMapper.class}
)
public interface LeagueMapper {

	LeagueOutDTO toDTO(League league);

	@Mapping(target = "teams", ignore = true)
	LeagueOutDTO toBasicDTO(League league);
}
