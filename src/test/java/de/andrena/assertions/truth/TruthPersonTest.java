package de.andrena.assertions.truth;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

import com.google.common.truth.Truth;

import de.andrena.assertions.Person;

public class TruthPersonTest {

	private Person person = new Person("Bob", "Doe");
	
	@Test
	public void firstNameIsEqual() {
		Truth.assertThat(person.getFirstName()).isEqualTo("John");
		assertThat(person.getFirstName()).isEqualTo("John");
		// Falsche Reihenfolge nicht möglich!
		// Vorteil: org.junit.ComparisonFailure (Eclipse und IntelliJ haben UI dafür!)
	}
	
	@Test
	public void firstNameSubstring() {
		assertThat(person.getFirstName()).contains("i");
	}

}
