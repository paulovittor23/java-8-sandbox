package com.sandbox.examples.done;

import java.text.SimpleDateFormat;

import com.sandbox.model.Athlete;
import com.sandbox.model.Gender;
import com.sandbox.model.Sport;

public class LambdaExample2 {
	
	public static void main(String[] args) throws Exception {
		
		final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Athlete athlete = new Athlete("Muhammad Ali", dateFormatter.parse("17/01/1942"), 191, Gender.MALE, Sport.BOX, "United States");
		
		methodOne(athlete);
		methodTwo(athlete);
	}
	
	public static void methodOne(Athlete athlete){
		sharedMethod(athlete, () -> athlete.doSomething());
	}
	
	public static void methodTwo(Athlete athlete){
		sharedMethod(athlete, () -> athlete.doSomethingElse());
	}
	
	public static void sharedMethod(Athlete athlete, Runnable block){
		System.out.println("sharedMethod...before block.run()");
		block.run();
		System.out.println("sharedMethod...after block.run()");
	}

}
