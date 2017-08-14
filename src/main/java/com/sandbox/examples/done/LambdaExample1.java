package com.sandbox.examples.done;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.function.Consumer;

import com.sandbox.model.Athlete;
import com.sandbox.model.Gender;
import com.sandbox.model.Sport;

public class LambdaExample1 {
	
	public static void main(String[] args) throws Exception {
		
		final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Athlete athlete = new Athlete("Muhammad Ali", dateFormatter.parse("17/01/1942"), 191, Gender.MALE, Sport.BOX, "United States");
		
		methodOne(athlete);
		System.out.println("athlete.positionInRanking: " + athlete.getPositionInRanking());
		System.out.println("athlete.anotherPositionInRanking: " + athlete.getAnotherPositionInRanking());
		
		methodTwo(athlete);
		System.out.println("athlete.positionInRanking: " + athlete.getPositionInRanking());
		System.out.println("athlete.anotherPositionInRanking: " + athlete.getAnotherPositionInRanking());
	}
	
	public static void methodOne(Athlete athlete){
		sharedMethod(athlete, positionInRanking -> athlete.setPositionInRanking(positionInRanking));
	}
	
	public static void methodTwo(Athlete athlete){
		sharedMethod(athlete, positionInRanking -> athlete.setAnotherPositionInRanking(positionInRanking));
	}
	
	public static void sharedMethod(Athlete athlete, Consumer<Integer> block){
		int randomIntegerBetween1and100 = new Random().ints(1, 1, 100).findFirst().getAsInt();
		block.accept(randomIntegerBetween1and100);		
	}

}
