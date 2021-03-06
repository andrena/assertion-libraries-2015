package de.andrena.assertions.plain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.andrena.assertions.Person;

public class PlainPersonTest {

	private Person bob = new Person("Bob", "Doe");

	@Test
	public void firstNameIsEqual() {
		Person person = new Person("Bob", "Doe");
		// assertEquals("Alice", person.getFirstName());

		// Falsche Reihenfolge -> irreführende Fehlermeldung
		assertEquals(person.getFirstName(), "Alice");
	}

	@Test
	public void firstNameSubstringWithoutMessage() {
		// Substring-Match: Keine sprechende Fehlermeldung
		assertTrue(bob.getFirstName().contains("i"));
	}

	@Test
	public void firstNameSubstringWithMessageExcludingActualValue() {
		// Substring-Match: Mit manuellere Fehlermeldung -> Aber was war der
		// tatsächliche String?
		assertTrue("person's first name must include an 'i'", bob
				.getFirstName().contains("i"));
	}

	@Test
	public void firstNameSubstringWithMessageIncludingActualValue() {
		// Substring-Match: Mit manuellere Fehlermeldung und tatsächlichem
		// String
		assertTrue(
				"person's first name must include an 'i', but was: '"
						+ bob.getFirstName() + "'", bob.getFirstName()
						.contains("i"));
	}
}
