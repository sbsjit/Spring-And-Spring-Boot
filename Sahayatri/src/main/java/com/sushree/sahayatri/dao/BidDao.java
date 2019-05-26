package com.sushree.sahayatri.dao;

import java.util.List;

import com.sushree.sahayatri.model.Bid;

public interface BidDao {

	public Bid save(Bid bid) ;

	public List<Bid> findAll();

	public Bid findOne(int bidId);

	public void delete(Bid bid);

}
