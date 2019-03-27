package com.global;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Globals_for_web {
	public static final List<Integer> DAYS_OF_MONTH = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 });

	public static final List<String> MONTHS_OF_YEAR = Arrays.asList(new String[] { "January", "February", "March",
			"April", "May", "June", "July", "August", "September", "October", "November", "December" });

	public static final Integer USER_MAX_AGE = 100;

	public static List<Integer> birthYears() {

		Integer[] years = new Integer[USER_MAX_AGE];
		int currentYear = LocalDate.now().getYear();
		for (int i = 0; i < years.length; i++) {
			years[i] = currentYear--;
		}

		return Arrays.asList(years);
	}

	public static final boolean isValidEmailAddress(String email) {
		
		String patternStr = "(?i)([\\w.-]+)@([a-z0-9-]+)\\.([a-z]{2,8})(\\.[a-z]{2,6})?";
		return Pattern.compile(patternStr).matcher(email).matches();

	}

	public static final boolean isValidUKPostcode(String postcode) {

		// The RegEx supplied by the UK Government to validate the UK Postcode
		String patternRex = "([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|"
				+ "(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|"
				+ "([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})";

		return Pattern.compile(patternRex).matcher(postcode).matches();
	}
}
//==================================================================================
//public static final Map<Integer, String> MONTHS_OF_YEAR = new
	// HashMap<Integer, String>();
	// static { //it is instance area, here not allowed to put data in map bcs not
	// method it is that's why static
	// MONTHS_OF_YEAR.put(0, "January");
	// MONTHS_OF_YEAR.put(1, "February");
	// MONTHS_OF_YEAR.put(2, "March");
	// MONTHS_OF_YEAR.put(3, "April");
	// MONTHS_OF_YEAR.put(4, "May");
	// MONTHS_OF_YEAR.put(5, "June");
	// MONTHS_OF_YEAR.put(6, "July");
	// MONTHS_OF_YEAR.put(7, "August");
	// MONTHS_OF_YEAR.put(8, "September");
	// MONTHS_OF_YEAR.put(9, "October");
	// MONTHS_OF_YEAR.put(10, "November");
	// MONTHS_OF_YEAR.put(11, "December");
	// }

	/*
	 * The maximum age of a person entering their birth date, set to 100.
	 */
