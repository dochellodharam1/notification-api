package com.trickyjava.how.eventtracker.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trickyjava.how.eventtracker.feign.dto.MedicalDrugsResponseDTO;
import com.trickyjava.how.eventtracker.feign.dto.TopHeadlinesResponseDTO;

@FeignClient(name = "DrugAPIMedFeign", url = "https://3yp0hp3wsh-dsn.algolia.net/1/indexes")
public interface DrugAPIMedFeign {

	@RequestMapping(path = "/prod_meds/query?x-algolia-application-id={appId}&x-algolia-api-key={apiKey}")
	MedicalDrugsResponseDTO findMedicalDrugs(@PathVariable("appId") String appId,
			@PathVariable("apiKey") String apiKey, Map<String, Object> body);
}
