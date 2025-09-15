package net.escoz.evaluation.presentation;

import net.escoz.evaluation.exceptions.NotFoundException;
import net.escoz.evaluation.presentation.dto.CustomErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

/**
 * Global exception handler for the application.
 * Handles various types of exceptions and returns custom error responses with appropriate HTTP status codes.
 */
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {NotFoundException.class})
	protected ResponseEntity<CustomErrorDTO> handleNotFoundException(Exception exception) {
		CustomErrorDTO response = CustomErrorDTO.builder()
				.timestamp(Instant.now().toString())
				.status(HttpStatus.NOT_FOUND.value())
				.error(exception.getMessage())
				.build();

		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(response);
	}
}