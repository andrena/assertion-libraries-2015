package de.andrena.assertions.hamcrest;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.andrena.assertions.Person;

public class HamcrestPersonTest {

	private Person person = new Person("Bob", "Doe");
	
	@Test
	public void firstNameIsEqual() {
		assertThat(person.getFirstName(), is("Alice"));
		// Falsche Reihenfolge nicht möglich!
	}
	
	@Test
	public void firstNameSubstring() {
		assertThat(person.getFirstName(), containsString("i"));
	}

}
