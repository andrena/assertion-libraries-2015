package de.andrena.assertions.truth;

import static com.google.common.truth.Truth.assertAbout;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.google.common.truth.TruthJUnit.assume;
import static de.andrena.assertions.truth.PersonSubject.person;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.truth.Truth;

import de.andrena.assertions.Person;

public class TruthPersonTest {

	private Person bob = new Person("Bob", "Doe");
	
	@Test
	public void firstNameIsEqual() {
		Truth.assertThat(bob.getFirstName()).isEqualTo("Alice");
		assertThat(bob.getFirstName()).isEqualTo("Alice");
		// Falsche Reihenfolge nicht möglich!
		// Vorteil: org.junit.ComparisonFailure (Eclipse und IntelliJ haben UI dafür!)
	}
	
	@Test
	public void firstNameSubstring() {
		assertThat(bob.getFirstName()).contains("i");
	}

	@Test
	public void firstNameWithCustomSubject() {
		assertAbout(person()).that(bob).hasFirstName("Alice");
	}
	
	@Test
	public void isInCollection() {
		Person alice = new Person("Alice", "Foo");
		Person charlie = new Person("Charlie", "Baz");
		List<Person> friends = Arrays.asList(alice, charlie);
		
		assertThat(friends).containsAllOf(alice, bob);
	}
	
	@Test
	public void combining() {
		assertThat(bob.getFirstName()).startsWith("B");
		assertThat(bob.getFirstName()).contains("o");
		assertThat(bob.getFirstName()).endsWith("b");
		
		Person alice = new Person("Alice", "Foo");
		Person charlie = new Person("Charlie", "Baz");
		List<Person> friends = Arrays.asList(alice, charlie);
		
		assert_().in(friends).thatEach(person()).hasFirstName("Bob");
	}
	
	@Test
	public void assumption() {
		assume().that(System.getProperty("my.setting")).contains("run");
	}

}
