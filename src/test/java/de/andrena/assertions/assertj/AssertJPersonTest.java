package de.andrena.assertions.assertj;

import static de.andrena.assertions.assertj.PersonAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.allOf;
import static org.assertj.core.api.StrictAssertions.anyOf;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.StrictAssertions.not;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.AssumptionViolatedException;
import org.junit.Test;

import de.andrena.assertions.Person;

public class AssertJPersonTest {

	private Person bob = new Person("Bob", "Doe");
	
	@Test
	public void firstNameIsEqual() {
		Assertions.assertThat(bob.getFirstName()).isEqualTo("Alice");
		assertThat(bob.getFirstName()).isEqualTo("Alice");
		// Falsche Reihenfolge nicht möglich!
		// Vorteil: org.junit.ComparisonFailure (Eclipse und IntelliJ haben UI dafür!)
	}
	
	@Test
	public void firstNameSubstring() {
		assertThat(bob.getFirstName()).contains("i");
	}

	@Test
	public void firstNameWithCustomAssertion() {
		assertThat(bob).hasFirstName("Alice");
	}

	@Test
	public void firstNameSubstringWithCustomAssertion() {
		assertThat(bob).firstName().contains("i");
	}

	@Test
	public void isInCollection() {
		Person alice = new Person("Alice", "Foo");
		Person charlie = new Person("Charlie", "Baz");
		List<Person> friends = Arrays.asList(alice, charlie);
		
		assertThat(friends).contains(alice, bob);
	}
	
	@Test
	public void combining() {
		assertThat(bob.getFirstName()).startsWith("B").contains("o").endsWith("b");
		
		assertThat(bob.getFirstName()).is(allOf(startsWith("B"), not(startsWith("A"))));
		assertThat(bob.getFirstName()).is(anyOf(startsWith("B"), startsWith("A")));
		
		Person alice = new Person("Alice", "Foo");
		Person charlie = new Person("Charlie", "Baz");
		List<Person> friends = Arrays.asList(alice, charlie);
		
		assertThat(friends).extracting(Person::getFirstName).contains("Alice", "Bob");
	}

	private static Condition<String> startsWith(String prefix) {
		return new Condition<>(s -> s.startsWith(prefix), "starts with %s", prefix);
	}
	
	@Test
	public void assumption() {
		assumeSucceeds(() -> {
			assertThat(System.getProperty("my.setting")).contains("run");
		});
	}
	
	private static void assumeSucceeds(Runnable runnable) {
		try {
			runnable.run();
		} catch (AssertionError e) {
			throw new AssumptionViolatedException(e.getMessage(), e.getCause());
		}
	}

}
