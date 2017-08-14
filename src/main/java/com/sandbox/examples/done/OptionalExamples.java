package com.sandbox.examples.done;

import java.text.SimpleDateFormat;
import java.util.Optional;

import com.sandbox.model.Athlete;
import com.sandbox.model.Gender;
import com.sandbox.model.Sport;

public class OptionalExamples {

	public static void main(String[] args) throws Exception {
		
		final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Athlete defaultAthlete = new Athlete("Muhammad Ali", dateFormatter.parse("17/01/1942"), 191, Gender.MALE, Sport.BOX, "United States");
		Athlete notNullAthlete = new Athlete("Michael Jordan", dateFormatter.parse("17/02/1963"), 198, Gender.MALE, Sport.BASKETBALL, "United States");
		Athlete nullAthlete = null;
		
		// creates an Optional object wrapping the athlete object 
		Optional<Athlete> optionalAthlete = Optional.ofNullable(notNullAthlete);
		
		// OR ELSE
		
		// returns the notNullAthlete unless it's null, otherwise returns the defaultAthlete
		Athlete notNullAthleteOrElse = Optional.ofNullable(notNullAthlete).orElse(defaultAthlete);
		System.out.println("orElse from notNullAthlete returned: " + notNullAthleteOrElse.getName());

		// returns the nullAthlete unless it's null, otherwise returns the defaultAthlete		
		Athlete nullAthleteOrElse = Optional.ofNullable(nullAthlete).orElse(defaultAthlete);
		System.out.println("orElse from nullAthlete returned: " + nullAthleteOrElse.getName());
		
		// IS PRESENT
		
		optionalAthlete = Optional.ofNullable(notNullAthlete);
		System.out.println("optional athlete (notNullAthlete) is present? " + optionalAthlete.isPresent());
		
		optionalAthlete = Optional.ofNullable(nullAthlete);
		System.out.println("optional athlete (nullAthlete) is present? " + optionalAthlete.isPresent());
		
		// IF PRESENT
		
		optionalAthlete = Optional.ofNullable(notNullAthlete);
		optionalAthlete.ifPresent(athlete -> System.out.println("because the notNullAthlete is present, this inline was printed"));
		optionalAthlete.ifPresent(athlete -> { 
			System.out.println("because the notNullAthlete is present, this line was printed.. 1");
			System.out.println("because the notNullAthlete is present, this line was printed.. 2");
		});
		
		optionalAthlete = Optional.ofNullable(nullAthlete);
		optionalAthlete.ifPresent(athlete -> System.out.println("because the nullAthlete is NOT present, this inline was NOT printed"));
		
		// MAP
		
		optionalAthlete = Optional.ofNullable(notNullAthlete);
		String notNullAthleteCountry = optionalAthlete.map(athlete -> athlete.getCountry()).orElse("Country not found");
		System.out.println("Country from notNullAthlete: " + notNullAthleteCountry);
		
		optionalAthlete = Optional.ofNullable(nullAthlete);
		String nullAthleteCountry = optionalAthlete.map(athlete -> athlete.getCountry()).orElse("Country not found");
		System.out.println("Country from nullAthlete: " + nullAthleteCountry);
		
		// FILTER
				
		optionalAthlete = Optional.ofNullable(notNullAthlete);
		boolean notNullAthleteIsF1Pilot = optionalAthlete.filter(athlete -> athlete.getSport().equals(Sport.BASKETBALL)).isPresent();
		System.out.println("Is notNullAthlete a Basketball player? " + notNullAthleteIsF1Pilot);
		
		optionalAthlete = Optional.ofNullable(nullAthlete);
		boolean nullAthleteIsF1Pilot = optionalAthlete.filter(athlete -> athlete.getSport().equals(Sport.BASKETBALL)).isPresent();
		System.out.println("Is nullAthlete a Basketball player? " + nullAthleteIsF1Pilot);
	}

}
