package net.escoz.evaluation.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PLAYERS")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false, unique = true)
	private String email;

	@ElementCollection
	@CollectionTable(
			name = "PLAYERS_POSITIONS",
			joinColumns = @JoinColumn(name = "player_id")
	)
	@Column(name = "position")
	private Set<String> positions = new HashSet<>();

	@ManyToOne(
			optional = false,
			fetch = FetchType.LAZY
	)
	@JoinColumn(
			name = "team_id",
			nullable = false
	)
	private Team team;
}
