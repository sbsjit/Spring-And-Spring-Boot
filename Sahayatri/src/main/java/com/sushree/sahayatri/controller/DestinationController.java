package com.sushree.sahayatri.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushree.sahayatri.dao.DestinationDao;
import com.sushree.sahayatri.model.Destination;

@RestController
@RequestMapping("/sahayatri")
public class DestinationController {
	
	@Autowired
	DestinationDao destinationDao;

	/* Save destination */
	@PostMapping("/destination")
	public Destination createDestination(@Valid @RequestBody Destination destination) {
		return destinationDao.save(destination);
	}

	/* Get all destination */
	@GetMapping("/destination")
	public List<Destination> getAllDestination() {
		return destinationDao.findAll();
	}
	

	/* Get Bid by "destinationId" */
	@GetMapping("/destination/{id}")
	/*{id} --- So @PathVariable value must be defined of the parameter*/
	public ResponseEntity<Destination> getDestinationById(@PathVariable(value = "id") int destinationId) {

		Destination destination= destinationDao.findOne(destinationId);

		if (destination == null) {
			/*This is basically the message you get  when you call the Rest-Api 
				when you dont find that particular id*/
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(destination);

	}

	/* Update an destination by destinationId*/
	@PutMapping("/destination/{id}")
	public ResponseEntity<Destination> updateDestination(@PathVariable(value = "id") int destinationId,
			@Valid @RequestBody Destination destinationDetails) {

		Destination destination = destinationDao.findOne(destinationId);
		if (destination == null) {
			return ResponseEntity.notFound().build();
		}

		destination.setName(destinationDetails.getName());
		
		Destination updateDestination = destinationDao.save(destination);
		return ResponseEntity.ok().body(updateDestination);

	}

	/* Delete an destination */
	@DeleteMapping("/destination/{id}")
	public ResponseEntity<Destination> deleteDestination(@PathVariable(value = "id") int destinationId) {

		Destination destination = destinationDao.findOne(destinationId);
		if (destination == null) {
			return ResponseEntity.notFound().build();
		}
		destinationDao.delete(destination);

		return ResponseEntity.ok().build();

	}
	
	
}
