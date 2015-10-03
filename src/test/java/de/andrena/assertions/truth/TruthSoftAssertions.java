package de.andrena.assertions.truth;

import static de.andrena.assertions.truth.PersonSubject.person;

import org.junit.Rule;
import org.junit.Test;

import com.google.common.truth.Expect;

import de.andrena.assertions.Person;

public class TruthSoftAssertions {
	
	@Rule
	public Expect expect = Expect.create();

	@Test
	public void slowTestWithoutRule() {
		expect.about(person()).that(new Person("Alice", "Bar")).hasFirstName("Bob");
		expect.about(person()).that(new Person("Bob", "Foo")).hasFirstName("Alice");
	}
}
