package net.escoz.evaluation.presentation.dto;

import lombok.Builder;

@Builder
public record CustomErrorDTO(String timestamp, int status, String error) {
}
