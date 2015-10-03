package de.andrena.assertions.assertj;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import de.andrena.assertions.Person;

public class AssertJSoftAssertions {

	@Test
	public void slowTestWithoutRule() {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(new Person("Alice", "Bar").getFirstName()).isEqualTo("Bob");
		softly.assertThat(new Person("Bob", "Foo").getFirstName()).isEqualTo("Alice");
		softly.assertAll();
	}
}
