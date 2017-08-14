package com.sandbox.examples.live;

import java.text.SimpleDateFormat;

import com.sandbox.model.Athlete;
import com.sandbox.model.Gender;
import com.sandbox.model.Sport;

public class OptionalHandsOn {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		
		final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Athlete defaultAthlete = new Athlete("Muhammad Ali", dateFormatter.parse("17/01/1942"), 191, Gender.MALE, Sport.BOX, "United States");
		
		Athlete notNullAthlete = new Athlete("Michael Jordan", dateFormatter.parse("17/02/1963"), 198, Gender.MALE, Sport.BASKETBALL, "United States");
		Athlete nullAthlete = null;
		
		// creates an Optional object wrapping the athlete object
				
		// OR ELSE
		
		// IS PRESENT
		
		// IF PRESENT
		
		// MAP
		
		// FILTER
		
	}

}
