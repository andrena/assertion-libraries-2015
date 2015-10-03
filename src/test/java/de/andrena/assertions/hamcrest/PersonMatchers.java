package de.andrena.assertions.hamcrest;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import de.andrena.assertions.Person;

public class PersonMatchers {

	public static Matcher<Person> hasFirstName(String firstName) {
		return hasFirstName(equalTo(firstName));
	}

	public static Matcher<Person> hasFirstName(Matcher<String> matcher) {
		return new FeatureMatcher<Person, String>(matcher,
				"a person with first name", "first name") {
			@Override
			protected String featureValueOf(Person actual) {
				return actual.getFirstName();
			}
		};
	}

}
