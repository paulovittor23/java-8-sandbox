package com.sandbox.model;

import java.util.Date;

public class Athlete {

	private String name;
	private Date birthdate;
	private Integer heightInCm;
	private Gender gender;
	private Sport sport;
	private String country;
	
	private transient Integer positionInRanking;
	private transient Integer anotherPositionInRanking;

	public Athlete(String name, Date birthdate, Integer heightInCm, Gender gender, Sport sport, String country) {
		this.name = name;
		this.birthdate = birthdate;
		this.heightInCm = heightInCm;
		this.gender = gender;
		this.sport = sport;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
	public Integer getHeightInCm() {
		return heightInCm;
	}

	public void setHeightInCm(Integer heightInCm) {
		this.heightInCm = heightInCm;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPositionInRanking() {
		return positionInRanking;
	}

	public void setPositionInRanking(Integer positionInRanking) {
		this.positionInRanking = positionInRanking;
	}
	
	public Integer getAnotherPositionInRanking() {
		return anotherPositionInRanking;
	}

	public void setAnotherPositionInRanking(Integer anotherPositionInRanking) {
		this.anotherPositionInRanking = anotherPositionInRanking;
	}

	@Override
	public String toString() {
		return name;
	}

	public void doSomething() {
		System.out.println("something was done..");
	}
	
	public void doSomethingElse() {
		System.out.println("something else was done..");
	}

}
