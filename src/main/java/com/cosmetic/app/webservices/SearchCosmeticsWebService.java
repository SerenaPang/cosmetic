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

	// curl -X GET "http://localhost:8080/searchByQuery?query=Lipstick"
	@GetMapping("/searchByQuery")
	public ResponseEntity<Cosmetic> searchByQuery(
			@RequestParam(value = "query", defaultValue = "nothing") String query) {
		System.out.println("SearchCosmeticsWebservice.searchByQuery() " + query);
		Cosmetic cosmetic = cosmeticService.searchBySearchString(query);
		System.out.println("cosmetics " + cosmetic);
		return ResponseEntity.status(HttpStatus.OK).body(cosmetic);
	}
	
	// curl -X GET "http://localhost:8080/findById?id=id"
	@GetMapping("/findById")
	public ResponseEntity<Cosmetic> findById(
			@RequestParam(value = "id", defaultValue = "nothing") long id) {
		System.out.println("SearchCosmeticsWebservice.findById() " + id);
		Cosmetic cosmetic = cosmeticService.findById(id);
		System.out.println("cosmetics " + cosmetic);
		return ResponseEntity.status(HttpStatus.OK).body(cosmetic);
	}
}
