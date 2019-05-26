package com.sushree.sahayatri.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushree.sahayatri.model.Package;
import com.sushree.sahayatri.repository.PackageRepository;

@Service
public class PackageDaoImpl implements PackageDao {

	@Autowired
	PackageRepository packageRepository;
	
	@Override
	public Package save(Package packages) {
		return packageRepository.save(packages);
	}

	@Override
	public List<Package> findAll() {
		return packageRepository.findAll();
	}

	@Override
	public Package findOne(int packageid) {
		return packageRepository.findOne((long) packageid);
	}

	@Override
	public void delete(Package packages) {
		packageRepository.delete(packages);
	}

}
