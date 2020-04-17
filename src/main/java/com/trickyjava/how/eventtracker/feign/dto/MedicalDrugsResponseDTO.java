package com.trickyjava.how.eventtracker.feign.dto;

import java.util.List;
import java.util.function.Supplier;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MedicalDrugsResponseDTO implements Supplier<DrugsResponseDTO>{

	@JsonProperty("hits")
	private List<DrugDTO> hits;

	@JsonProperty("nbHits")
	private long nbHits;
	@JsonProperty("page")
	private long page;
	@JsonProperty("nbPages")
	private long nbPages;
	@Override
	public DrugsResponseDTO get() {
		DrugsResponseDTO responseDto = new DrugsResponseDTO();
		responseDto.setMedicines(hits);
		responseDto.setTotalResults(nbHits);
		responseDto.setNoOfPages(nbPages);
		responseDto.setCurrentPage(page);
		return responseDto;
	}

}
