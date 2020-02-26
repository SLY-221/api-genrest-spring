package fr.amu.genrest.projects.bot.building;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * 
 * @author Tsila, Bachir, Fazia
 *
 */

@Embeddable
public @Data class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String street;
	private String city;
	private String country;
	
	public Address() {
		super();
	}

	public Address(String street, String city, String country) {
		super();
		setStreet(street);
		setCity(city);
		setCountry(country);
	}
}
