package com.sushree.sahayatri.dao;

import java.util.List;

import com.sushree.sahayatri.model.Destination;

public interface DestinationDao {

	public Destination save(Destination destination);

	public List<Destination> findAll();

	public Destination findOne(int destinationid);

	public void delete(Destination destination);

	
}
