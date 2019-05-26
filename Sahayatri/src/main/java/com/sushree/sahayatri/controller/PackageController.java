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

import com.sushree.sahayatri.dao.PackageDao;
import com.sushree.sahayatri.model.Package;

@RestController
@RequestMapping("/sahayatri")
public class PackageController {
	@Autowired
	PackageDao packageDao;

	/* Save Package */
	@PostMapping("/package")
	public Package createPackage(@Valid @RequestBody Package packages) {
		return packageDao.save(packages);
	}

	/* Get all packages */
	@GetMapping("/packages")
	public List<Package> getAllPackage() {
		return packageDao.findAll();
	}
	

	/* Get package by "packageId" */
	@GetMapping("/package/{id}")
	public ResponseEntity<Package> getPackageById(@PathVariable(value = "id") int packageId) {

		Package packages= packageDao.findOne(packageId);

		if (packages == null) {
			/*This is basically the message you get  when you call the Rest-Api 
				when you dont find that particular id*/
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(packages);

	}

	/* Update an package by packageId*/
	@PutMapping("/package/{id}")
	public ResponseEntity<Package> updatePackage(@PathVariable(value = "id") int packageId,
			@Valid @RequestBody Package packageDetails) {

		Package packages= packageDao.findOne(packageId);
		if (packages == null) {
			return ResponseEntity.notFound().build();
		}

		packages.setName(packageDetails.getName());
		packages.setDays(packageDetails.getDays());
		
		Package updatePackage = packageDao.save(packages);
		return ResponseEntity.ok().body(updatePackage);

	}

	/* Delete a package */
	@DeleteMapping("/package/{id}")
	public ResponseEntity<Package> deletePackage(@PathVariable(value = "id") int packageId) {

		Package packages = packageDao.findOne(packageId);
		if (packages == null) {
			return ResponseEntity.notFound().build();
		}
		packageDao.delete(packages);

		return ResponseEntity.ok().build();

	}
	
	
}
