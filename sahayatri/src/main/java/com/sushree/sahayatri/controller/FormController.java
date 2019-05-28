package com.sushree.sahayatri.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sushree.sahayatri.model.User;

@Controller
public class FormController {

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String fill() {

		return "form";
	}

	

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String form(@ModelAttribute User t) {
		
		String HashValue="";
		
		try {

			// Static getInstance method is called with hashing SHA
			MessageDigest md = MessageDigest.getInstance("MD2");

			// digest() method called
			// to calculate message digest of traveler object and return array of byte
			byte[] messageDigest = md.digest(t.getUsername().getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			HashValue = no.toString(16);

			while (HashValue.length() < 32) {
				HashValue = "0" + HashValue;
			}
			System.out.println(HashValue);
			return "home";
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			System.out.println("Exception thrown" + " for incorrect algorithm: " + e);

			return "form";
		}

		
	}

}
