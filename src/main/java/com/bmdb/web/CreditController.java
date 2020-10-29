package com.bmdb.web;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Credit;
import com.bmdb.db.CreditRepo;


@CrossOrigin
@RestController
@RequestMapping("/credits")
public class CreditController {
	
	@Autowired
	private CreditRepo creditRepo;

	// list all credits
	@GetMapping("/")
	public List<Credit> getAllCredits() {
		return creditRepo.findAll();
	}

	// get credit by id
	@GetMapping("/{id}")
	public Optional getCredit(@PathVariable int id) {
		Optional<Credit> c = creditRepo.findById(id);
		if (c.isPresent()) {
			return c;	
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Credit not found");
		}	
	}

	// add a credit
	@PostMapping("/")
	/*
	 * incoming json request must be translated into java that's why we add
	 * the @RequstedBody to the Credit object
	 */
	public Credit addActor(@RequestBody Credit c) {
		return creditRepo.save(c);
	}

	// update a credit
	@PutMapping("/")
	// incoming json request must be translated into java that's why
	// we add the @RequstedBody to the Credit object
	public Credit updateCredit(@RequestBody Credit c) {
		return creditRepo.save(c);
	}

	// delete a credit
	@DeleteMapping("/")
	public Credit deleteCredit(@RequestBody Credit c) {
		creditRepo.delete(c);
		return c;
	}
}