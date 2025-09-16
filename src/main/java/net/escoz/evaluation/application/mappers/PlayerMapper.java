package net.escoz.evaluation.application.mappers;

import net.escoz.evaluation.application.services.TeamService;
import net.escoz.evaluation.domain.entities.Player;
import net.escoz.evaluation.presentation.dto.player.PlayerBasicOutDTO;
import net.escoz.evaluation.presentation.dto.player.PlayerInDTO;
import net.escoz.evaluation.presentation.dto.player.PlayerOutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
		componentModel = "spring",
		uses = TeamService.class
)
public interface PlayerMapper {

	@Mapping(target = "team", source = "team.name")
	@Mapping(target = "league", source = "team.league.name")
	PlayerOutDTO toDTO(Player player);

	@Mapping(target = "team", source = "team.name")
	@Mapping(target = "fullName", expression = "java(mapToFullName(player))")
	PlayerBasicOutDTO toBasicDTO(Player player);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "team", source = "teamId")
	Player toModel(PlayerInDTO playerInDTO);

	default String mapToFullName(Player player) {
		return player.getName() + " " + player.getSurname();
	}
}
