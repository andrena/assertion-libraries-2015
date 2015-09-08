package de.andrena.assertions;

import static java.util.Collections.unmodifiableList;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;

public class Person {

	private final String firstName;
	private final String lastName;
	private final LocalDate birthday;
	private final List<Address> addresses = new LinkedList<>();

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

	public void add(Address address) {
		addresses.add(address);
	}

	public void remove(Address address) {
		addresses.remove(address);
	}

	public List<Address> getAddresses() {
		return unmodifiableList(addresses);
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public Person withoutBirthday() {
		Person person = new Person(firstName, lastName, null);
		person.addresses.addAll(this.addresses);
		return person;
	}

	public int getAgeInYears() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
