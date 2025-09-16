package net.escoz.evaluation.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CustomErrorDTO(String timestamp, int status, String error, List<String> errorDetails) {
}
