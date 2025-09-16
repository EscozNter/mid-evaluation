package net.escoz.evaluation.presentation.dto;

import lombok.Builder;

@Builder
public record BasicResponseDTO(int status, String message) {
}
