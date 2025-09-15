package net.escoz.evaluation.application.mappers;

import net.escoz.evaluation.domain.entities.Player;
import net.escoz.evaluation.presentation.dto.player.PlayerBasicOutDTO;
import net.escoz.evaluation.presentation.dto.player.PlayerOutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

	@Mapping(target = "team", source = "team.name")
	PlayerOutDTO toDTO(Player player);

	@Mapping(target = "team", source = "team.name")
	@Mapping(target = "fullName", expression = "java(mapToFullName(player))")
	PlayerBasicOutDTO toBasicDTO(Player player);

	default String mapToFullName(Player player) {
		return player.getName() + " " + player.getSurname();
	}
}
