package com.bmdb.web;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepo;


@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController {
	
	@Autowired
	private ActorRepo actorRepo;

	// list all actors
	@GetMapping("/")
	public List<Actor> getAllActors() {
		return actorRepo.findAll();
	}

	// get actor by id
	@GetMapping("/{id}")
	public Optional<Actor> getActor(@PathVariable int id) {
		Optional<Actor> a = actorRepo.findById(id);
		if (a.isPresent()) {
			return a;	
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found");
		}
	}
		

	// add an actor
	@PostMapping("/")
	/*
	 * incoming json request must be translated into java that's why we add
	 * the @RequstedBody to the Actor object
	 */
	public Actor addActor(@RequestBody Actor a) {
		return actorRepo.save(a);
	}

	// update an actor
	@PutMapping("/")
	// incoming json request must be translated into java that's why
	// we add the @RequstedBody to the Actor object
	public Actor updateActor(@RequestBody Actor a) {
		return actorRepo.save(a);
	}

	// delete an actor
	@DeleteMapping
	public Actor deleteActor(@RequestBody Actor a) {
		actorRepo.delete(a);
		return a;
	}
	
}