package net.escoz.evaluation.application.mappers;

import net.escoz.evaluation.application.services.TeamService;
import net.escoz.evaluation.domain.entities.Player;
import net.escoz.evaluation.presentation.dto.player.PlayerBasicOutDTO;
import net.escoz.evaluation.presentation.dto.player.PlayerInDTO;
import net.escoz.evaluation.presentation.dto.player.PlayerOutDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

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

	@Mapping(target = "team", source = "playerInDTO.teamId")
	Player toModelWithId(PlayerInDTO playerInDTO, long id);

	@Mapping(target = "id", ignore = true)
	// updatePlayer ignora team para evitar que MapStruct lo resuelva con TeamService
	// es una guarrada, pero me da pereza hacer las cosas bien :) asi que lo hacemos a mano.
	@Mapping(target = "team", ignore = true)
	Player updatePlayer(Player source, @MappingTarget Player target);

	@AfterMapping
	default void updateTeam(Player source, @MappingTarget Player target) {
		if (!source.getTeam().equals(target.getTeam()))
			target.setTeam(source.getTeam());
	}

	default String mapToFullName(Player player) {
		return player.getName() + " " + player.getSurname();
	}
}
