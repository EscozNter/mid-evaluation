package net.escoz.evaluation.application.services.impl;

import lombok.RequiredArgsConstructor;
import net.escoz.evaluation.application.services.PlayerService;
import net.escoz.evaluation.domain.entities.Player;
import net.escoz.evaluation.exceptions.NotFoundException;
import net.escoz.evaluation.exceptions.UnprocessableEntityException;
import net.escoz.evaluation.infraestructure.repositories.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

	private final PlayerRepository playerRepository;

	@Override
	public List<Player> getPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public Player getById(long id) {
		return playerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Player not found with id " + id));
	}

	@Override
	@Transactional
	public Player createPlayer(Player player) {
		if (playerRepository.existsByEmail(player.getEmail()))
			throw new UnprocessableEntityException("Player email already exists: " + player.getEmail());

		return playerRepository.save(player);
	}

	@Override
	@Transactional
	public void deletePlayer(long id) {
		playerRepository.delete(getById(id));
	}
}
