package com.sushree.sahayatri.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushree.sahayatri.model.Destination;
import com.sushree.sahayatri.repository.DestinationRepository;

@Service
public class DestinationDaoImpl implements DestinationDao {

	@Autowired
	DestinationRepository destinationRepository;
	
	
	public Destination save(Destination destination) {
		return destinationRepository.save(destination);
		// save() is provided by JPA in spring boot
	}

	public List<Destination> findAll() {
		return destinationRepository.findAll();
	}

	public Destination findOne(int destinationid) {
		return destinationRepository.findOne((long) destinationid);
	}

	public void delete(Destination destination) {
		destinationRepository.delete(destination);
	}

}
