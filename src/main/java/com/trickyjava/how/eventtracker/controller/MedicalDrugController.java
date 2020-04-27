package com.trickyjava.how.eventtracker.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trickyjava.how.eventtracker.feign.DrugAPIMedFeign;
import com.trickyjava.how.eventtracker.feign.dto.DrugsResponseDTO;

@RestController
@RequestMapping("/medical-drugs")
public class MedicalDrugController {

	@Value("${drug.api.key}")
	private String key;

	@Value("${drug.api.app-id}")
	private String appId;

	@Autowired
	private DrugAPIMedFeign drugAPIMedFeign;

	@CrossOrigin
	@GetMapping("/{medicine}")
	public ResponseEntity<DrugsResponseDTO> findMed(@PathVariable("medicine") String medicine,
			@RequestParam(defaultValue = "6", name = "resultCount", required = false) int resultCount) {
		Map<String, Object> body = new HashMap<>();
		body.put("params", "query=" + medicine + "&hitsPerPage=" + resultCount + "&clickAnalytics=true");
		DrugsResponseDTO drugResponse = drugAPIMedFeign.findMedicalDrugs(appId, key, body).get();
		return ResponseEntity.ok(drugResponse);
	}
}
