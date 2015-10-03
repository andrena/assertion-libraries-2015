package de.andrena.assertions.assertj;

import java.util.Objects;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.api.Assertions;

import de.andrena.assertions.Person;

public class PersonAssert extends AbstractAssert<PersonAssert, Person> {

	protected PersonAssert(Person actual) {
		super(actual, PersonAssert.class);
	}

	public static PersonAssert assertThat(Person actual) {
		return new PersonAssert(actual);
	}

	public PersonAssert hasFirstName(String expectedFirstName) {
		isNotNull();
		String actualFirstName = actual.getFirstName();
		if (!Objects.equals(actualFirstName, expectedFirstName)) {
			failWithMessage(
					"Expected person's first name to be <%s> but was <%s>",
					expectedFirstName, actualFirstName);
		}
		return this;
	}

	public AbstractCharSequenceAssert<?, String> firstName() {
		isNotNull();
		return Assertions.assertThat(actual.getFirstName());
	}
}
