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

import com.sushree.sahayatri.dao.BidDao;
import com.sushree.sahayatri.model.Bid;

@RestController
@RequestMapping("/sahayatri")
public class BidController {
	
	@Autowired
	BidDao bidDao;

	/* Save Bid */
	@PostMapping("/bid")
	public Bid createBid(@Valid @RequestBody Bid bid) {
		return bidDao.save(bid);
	}

	/* Get all Bids */
	@GetMapping("/bid")
	public List<Bid> getAllBid() {
		return bidDao.findAll();
	}
	

	/* Get Bid by "bidId" */
	@GetMapping("/bid/{id}")
	/*{id} --- So @PathVariable value must be defined of the parameter*/
	public ResponseEntity<Bid> getBidById(@PathVariable(value = "id") int bidId) {

		Bid bid= bidDao.findOne(bidId);

		if (bid == null) {
			/*This is basically the message you get  when you call the Rest-Api 
				when you dont find that particular id*/
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(bid);

	}

	/* Update an Bid by bidId*/
	@PutMapping("/bid/{id}")
	public ResponseEntity<Bid> updateBid(@PathVariable(value = "id") int bidId,
			@Valid @RequestBody Bid bidDetails) {

		Bid bid = bidDao.findOne(bidId);
		if (bid == null) {
			return ResponseEntity.notFound().build();
		}

		bid.setAgentId(bidDetails.getAgentId());
		bid.setGroupId(bidDetails.getGroupId());
		bid.setPrice(bidDetails.getPrice());
		bid.setStatus(bidDetails.getStatus());
		bid.setService(bidDetails.getService());

		Bid updateBid = bidDao.save(bid);
		return ResponseEntity.ok().body(updateBid);

	}

	/* Delete an bid */
	@DeleteMapping("/bid/{id}")
	public ResponseEntity<Bid> deleteBid(@PathVariable(value = "id") int bidId) {

		Bid bid = bidDao.findOne(bidId);
		if (bid == null) {
			return ResponseEntity.notFound().build();
		}
		bidDao.delete(bid);

		return ResponseEntity.ok().build();

	}
	
}
