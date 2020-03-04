package fr.amu.genrest.projects.bot.building;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author Tsila, Bachir, Fazia
 *
 */

@Embeddable
@AllArgsConstructor
public @Data class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int number;
	private String street;
	private String city;
	private String country;
	
	public Address() {
		super();
	}

//	public Address(int number, String street, String city, String country) {
//		super();
//		setNumber(number);
//		setStreet(street);
//		setCity(city);
//		setCountry(country);
//	}
}
