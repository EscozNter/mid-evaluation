package net.escoz.evaluation.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TEAMS")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@ManyToOne(
			optional = false,
			fetch = FetchType.LAZY
	)
	@JoinColumn(name = "league_id", nullable = false)
	private League league;

	@OneToMany(mappedBy = "team")
	private Set<Player> players = new HashSet<>();

}
