package de.andrena.assertions.assertj;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import de.andrena.assertions.Person;

public class AssertJPersonTest {

	private Person person = new Person("Bob", "Doe");
	
	@Test
	public void firstNameIsEqual() {
		Assertions.assertThat(person.getFirstName()).isEqualTo("John");
		assertThat(person.getFirstName()).isEqualTo("John");
		// Falsche Reihenfolge nicht möglich!
		// Vorteil: org.junit.ComparisonFailure (Eclipse und IntelliJ haben UI dafür!)
	}
	
	@Test
	public void firstNameSubstring() {
		assertThat(person.getFirstName()).contains("i");
	}

}
