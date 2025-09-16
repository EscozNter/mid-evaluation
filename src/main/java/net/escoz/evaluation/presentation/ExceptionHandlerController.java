package net.escoz.evaluation.presentation;

import net.escoz.evaluation.exceptions.NotFoundException;
import net.escoz.evaluation.exceptions.UnprocessableEntityException;
import net.escoz.evaluation.presentation.dto.CustomErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.List;

/**
 * Global exception handler for the application.
 * Handles various types of exceptions and returns custom error responses with appropriate HTTP status codes.
 */
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {NotFoundException.class})
	protected ResponseEntity<CustomErrorDTO> handleNotFoundException(NotFoundException exception) {
		return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {UnprocessableEntityException.class})
	protected ResponseEntity<CustomErrorDTO> handleUnprocessableEntityException(UnprocessableEntityException exception) {
		return buildResponse(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
	                                                              @NonNull HttpHeaders headers,
	                                                              @NonNull HttpStatusCode status,
	                                                              @NonNull WebRequest request) {

		List<ObjectError> errors = exception.getBindingResult().getAllErrors();
		CustomErrorDTO response = CustomErrorDTO.builder()
				.timestamp(Instant.now().toString())
				.status(HttpStatus.BAD_REQUEST.value())
				.errorDetails(errors.stream()
						.map(ObjectError::getDefaultMessage)
						.toList())
				.build();

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(response);
	}

	private ResponseEntity<CustomErrorDTO> buildResponse(String message, HttpStatus status) {
		CustomErrorDTO response = CustomErrorDTO.builder()
				.timestamp(Instant.now().toString())
				.status(status.value())
				.error(message)
				.build();

		return ResponseEntity
				.status(status)
				.body(response);
	}
}