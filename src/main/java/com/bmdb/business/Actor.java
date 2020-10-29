package com.bmdb.business;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private LocalDate birthDate;
	
	public Actor() {
		super();
	}
	
	public Actor(int id, String firstName, String lastName, String gender, LocalDate birthDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public Actor(String firstName, String lastName, String gender, LocalDate birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String displaySummary() {
		String str = "id: "+ id + ", "+firstName +" "+lastName+", "
				+ (gender.equalsIgnoreCase("M") ? "male" : "female") 
				+ ", born "+birthDate;
		return str;
	}
}
