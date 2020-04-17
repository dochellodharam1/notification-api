package com.trickyjava.how.eventtracker.feign.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DrugsResponseDTO {

	private List<DrugDTO> medicines;
	
	private long totalResults;
	
	private long noOfPages;
	
	private long currentPage;
	
}
