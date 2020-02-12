package consorcio.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import consorcio.example.domain.Drugstore;
import consorcio.example.service.DrugstoreService;



@RestController
public class DrugstoreController {
	
	@Autowired
	DrugstoreService service;

	@GetMapping("/drugstore")
	public List<Drugstore> drugstores(@RequestParam(required = true, value = "locationName") String locationName, @RequestParam(required = true,value = "drugstoreName") String drugstoreName) {
		return service.getDrugstoreByLocation(locationName, drugstoreName);
	}
	
}
