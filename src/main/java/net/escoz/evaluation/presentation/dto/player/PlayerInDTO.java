package net.escoz.evaluation.presentation.dto.player;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class PlayerInDTO {

	@NotBlank(message = "Name cannot be null or empty")
	private String name;

	@NotBlank(message = "Surname cannot be null or empty")
	private String surname;

	@Min(value = 16, message = "Age must be 16 or older")
	private int age;

	@Email(message = "Invalid email format")
	@NotBlank(message = "Email cannot be null or empty")
	private String email;

	private List<String> positions;

	private long teamId;
}
