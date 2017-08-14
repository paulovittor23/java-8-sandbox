package com.sandbox.examples.done;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Years;

import com.sandbox.model.Athlete;
import com.sandbox.model.Gender;
import com.sandbox.model.Sport;

public class StreamExamples {

	public static void main(String[] args) throws ParseException {
		
		final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Athlete> athletes = new ArrayList<Athlete>();
		athletes.add(new Athlete("Michael Jordan", dateFormatter.parse("17/02/1963"), 198, Gender.MALE, Sport.BASKETBALL, "United States"));
		athletes.add(new Athlete("Muhammad Ali", dateFormatter.parse("17/01/1942"), 191, Gender.MALE, Sport.BOX, "United States"));
		athletes.add(new Athlete("Serena Williams", dateFormatter.parse("26/09/1981"), 175, Gender.FEMALE, Sport.TENNIS, "United States"));
		athletes.add(new Athlete("Marta Vieira", dateFormatter.parse("19/02/1986"), 163, Gender.FEMALE, Sport.SOCCER, "Brazil"));
		athletes.add(new Athlete("Maria Sharapova", dateFormatter.parse("19/04/1987"), 188, Gender.FEMALE, Sport.TENNIS, "Russia"));
		athletes.add(new Athlete("Roger Federer", dateFormatter.parse("08/08/1981"), 185, Gender.MALE, Sport.TENNIS, "Switzerland"));
		athletes.add(new Athlete("Neymar JR", dateFormatter.parse("05/02/1992"), 175, Gender.MALE, Sport.SOCCER, "Brazil"));
		athletes.add(new Athlete("Usain Bolt", dateFormatter.parse("21/08/1986"), 195, Gender.MALE, Sport.TRACK_AND_FIELD, "Jamaica"));
		athletes.add(new Athlete("Mike Tyson", dateFormatter.parse("30/06/1966"), 178, Gender.MALE, Sport.BOX, "United States"));
		athletes.add(new Athlete("Michael Schumacher", dateFormatter.parse("03/01/1969"), 174, Gender.MALE, Sport.F1_RACING, "Germany"));

		// quantity of female athletes (filter + count)
		long femaleAthletesCount = athletes.stream()
				.filter(a -> a.getGender() == Gender.FEMALE)
				.count();
		
		System.out.println("female athletes count: " + femaleAthletesCount);
		
		// list of American athlete names (filter + map + collect)
		List<String> americanAthleteNames = athletes.stream()
			.filter(a -> a.getCountry().equals("United States"))
			.map(a-> a.getName())
			.collect(Collectors.toList());
		
		System.out.println("american athletes names: " + americanAthleteNames);
		
		// checks if all athletes were born in September (allMatch)
		boolean allAthletesBornInSeptember = athletes.stream()
			.allMatch(a -> new DateTime(a.getBirthdate()).getMonthOfYear() == DateTimeConstants.SEPTEMBER);
		
		System.out.println("were all athletes born in September? " + allAthletesBornInSeptember);
		
		// checks if at least one athlete was born in September (anyMatch)
		boolean atLeastOneAthleteBornInSeptember = athletes.stream()
			.anyMatch(a -> new DateTime(a.getBirthdate()).getMonthOfYear() == DateTimeConstants.SEPTEMBER);
		
		System.out.println("was at least one athlete born in September? " + atLeastOneAthleteBornInSeptember);
		
		// checks if no athletes were born in September (noneMatch)
		boolean noAthletesBornInSeptember = athletes.stream()
					.noneMatch(a -> new DateTime(a.getBirthdate()).getMonthOfYear() == DateTimeConstants.SEPTEMBER);
		
		System.out.println("were all athletes not born in September? " + noAthletesBornInSeptember);
		
		// maps athletes by country (collect using groupingBy)
		Map<String, List<Athlete>> athletesByCountry = athletes.stream()
			.collect(Collectors.groupingBy(Athlete::getCountry));
		
		System.out.println("athletes by country: " + athletesByCountry);
		
		// maps athletes by country (collect using groupingBy)
		Map<Gender, List<Athlete>> athletesByGender = athletes.stream()
			.collect(Collectors.groupingBy(Athlete::getGender));
		
		System.out.println("athletes by gender: " + athletesByGender);
		
		// average athletes age (mapToInt + average)
		double averageAthletesAge = athletes.stream()
			.mapToInt(a -> Years.yearsBetween(new DateTime(a.getBirthdate()), DateTime.now()).getYears())
			.average()
	        .getAsDouble();
		
		System.out.println("average athletes age: " + averageAthletesAge);
		
		// tallest athlete (max)
		Athlete tallestAthlete = athletes.stream()
			.max((athlete1, athlete2) -> Integer.compare(athlete1.getHeightInCm(), athlete2.getHeightInCm()))
			.get();
		
		System.out.println("tallest athlete: " + tallestAthlete);

		// sum of all athletes height (mapToInt + sum)
		int allAthletesHeight = athletes.stream().mapToInt(Athlete::getHeightInCm).sum();
		
		System.out.println("all athletes height: " + allAthletesHeight);
		
		// list of athletes sort by height (ASC)
		List<Athlete> athletesSortedByHeightASC = athletes.stream()
			.sorted(Comparator.comparingInt(Athlete::getHeightInCm))
			.collect(Collectors.toList());
		
		System.out.println("athletes sort by height (ASC): " + athletesSortedByHeightASC);
		
		// list of athletes sort by height (DESC)
		List<Athlete> athletesSortedByHeightDESC = athletes.stream()
			.sorted(Comparator.comparingInt(Athlete::getHeightInCm).reversed())
			.collect(Collectors.toList());
		
		System.out.println("athletes sort by height (DESC): " + athletesSortedByHeightDESC);
		
		// maps sports by country
		Map<String, Set<Sport>> sportsByCountry = athletes.stream()
			.collect(
				Collectors.groupingBy(Athlete::getCountry, Collectors.mapping(Athlete::getSport, Collectors.toSet()))
			);
		System.out.println("sports by country: " + sportsByCountry);
	}

}
