package de.andrena.assertions.hamcrest;

import static de.andrena.assertions.hamcrest.PersonMatchers.hasFirstName;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import de.andrena.assertions.Person;

public class HamcrestSoftAssertions {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void slowTest() {
		collector.checkThat(new Person("Alice", "Bar"), hasFirstName("Bob"));
		collector.checkThat(new Person("Bob", "Foo"), hasFirstName("Alice"));
	}
}
