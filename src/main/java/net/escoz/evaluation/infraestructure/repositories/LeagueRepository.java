package net.escoz.evaluation.infraestructure.repositories;

import net.escoz.evaluation.domain.entities.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
}