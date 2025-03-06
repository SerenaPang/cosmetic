package com.cosmetic.app.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.service.CosmeticService;

@RestController
public class SearchCosmeticsWebService {
	@Autowired
	private CosmeticService cosmeticService;

	// curl -X GET "http://localhost:8080/searchByQuery?query=mycosmetic"
	@GetMapping("/searchByQuery")
	public ResponseEntity<List<Cosmetic>> searchByQuery(
			@RequestParam(value = "query", defaultValue = "nothing") String query) {
		System.out.println("SearchCosmeticsWebservice.searchByQuery() " + query);
		List<Cosmetic> cosmetics = cosmeticService.searchBySearchString(query);
		System.out.println("cosmetics " + cosmetics);
		return ResponseEntity.status(HttpStatus.OK).body(cosmetics);
	}
	
	
}
