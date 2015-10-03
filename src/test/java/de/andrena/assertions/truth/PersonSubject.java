package de.andrena.assertions.truth;

import java.util.Objects;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import de.andrena.assertions.Person;

public class PersonSubject extends Subject<PersonSubject, Person> {

	public static SubjectFactory<PersonSubject, Person> person() {
		return new SubjectFactory<PersonSubject, Person>() {
			@Override
			public PersonSubject getSubject(FailureStrategy fs, Person target) {
				return new PersonSubject(fs, target);
			}
		};
	}

	protected PersonSubject(FailureStrategy failureStrategy, Person subject) {
		super(failureStrategy, subject);
	}

	public void hasFirstName(String expectedFirstName) {
		isNotNull();
		String actualFirstName = getSubject().getFirstName();
		if (!Objects.equals(actualFirstName, expectedFirstName)) {
			failWithBadResults("has first name", expectedFirstName, 
					"was", actualFirstName);
		}
	}
}
