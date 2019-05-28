package com.sushree.sahayatri.dao;

import java.util.List;

import com.sushree.sahayatri.model.Package;

public interface PackageDao {
	public Package save(Package packages);

	public List<Package> findAll();

	public Package findOne(int packageid);

	public void delete(Package packages);

}
