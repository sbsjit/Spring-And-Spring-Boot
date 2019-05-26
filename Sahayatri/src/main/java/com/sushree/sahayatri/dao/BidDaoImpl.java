package com.sushree.sahayatri.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushree.sahayatri.model.Bid;
import com.sushree.sahayatri.repository.BidRepository;

@Service
public class BidDaoImpl implements BidDao {

	@Autowired
	BidRepository bidRepository;
	
	@Override
	public Bid save(Bid bid) {
		return bidRepository.save(bid);
		// save() is provided by JPA in spring boot
	}

	@Override
	public List<Bid> findAll() {
		return bidRepository.findAll();
	}

	@Override
	public Bid findOne(int bidid) {
		return bidRepository.findOne((long) bidid);
	}

	@Override
	public void delete(Bid bid) {
		bidRepository.delete(bid);
	}

}
