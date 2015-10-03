package de.andrena.assertions;

import java.time.LocalDate;
import java.time.Period;

public class Person {

	private final String firstName;
	private final String lastName;
	private final LocalDate birthday;

	public Person(String firstName, String lastName) {
		this(firstName, lastName, null);
	}

	public Person(String firstName, String lastName, LocalDate birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public int getAgeInYears() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
