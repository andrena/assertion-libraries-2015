package de.andrena.assertions.hamcrest;

import static de.andrena.assertions.hamcrest.PersonMatchers.hasFirstName;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.andrena.assertions.Person;

public class HamcrestPersonTest {

	private Person bob = new Person("Bob", "Doe");

	@Test
	public void firstNameIsEqual() {
		assertThat(bob.getFirstName(), is("Alice"));
		// Falsche Reihenfolge nicht möglich!
	}

	@Test
	public void firstNameSubstring() {
		assertThat(bob.getFirstName(), containsString("i"));
	}

	@Test
	public void isInCollection() {
		Person alice = new Person("Alice", "Foo");
		Person charlie = new Person("Charlie", "Baz");
		List<Person> friends = Arrays.asList(alice, charlie);

		assertThat(friends, hasItems(alice, bob));
	}

	@Test
	public void firstNameWithCustomMatcher() {
		assertThat(bob, hasFirstName("Alice"));
	}

	@Test
	public void firstNameSubstringWithCustomMatcher() {
		assertThat(bob, hasFirstName(containsString("i")));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void combiningMatchers() {
		assertThat(bob.getFirstName(), 
				allOf(startsWith("B"), not(startsWith("A"))));
		assertThat(bob.getFirstName(), anyOf(startsWith("B"), startsWith("A")));
		
		Person alice = new Person("Alice", "Foo");
		Person charlie = new Person("Charlie", "Baz");
		List<Person> friends = Arrays.asList(alice, charlie);
		assertThat(friends, hasItems(hasFirstName("Alice"), hasFirstName(startsWith("C"))));
	}
	
	@Test
	public void assumption() {
		assumeThat(System.getProperty("my.setting"), containsString("run"));
	}

}
