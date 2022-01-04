package ru.example.homeWork1.tests;

import org.junit.jupiter.api.Test;
import ru.example.homeWork1.pages.PageFormStudents;
import ru.example.homeWork1.testData.FormStudents;

import static com.codeborne.selenide.Selenide.open;

public class InputFormPracticeTest extends BaseTest {
	@Test
	public void shouldSeeFullOfForm() {
		FormStudents students = new FormStudents();

		open("/automation-practice-form", PageFormStudents.class)
			.setFirstName(students.getFirstName())
			.setLastName(students.getLastName())
			.setUserEmail(students.getUserEmail())
			.setUserNumber(students.getUserNumber())
			.setGender(students.getGender())
			.setBirthDay()
			.setSubject(students.getSubjects())
			.setHobbies(students.getHobbies())
			.setUploadPicture(students.getPathImage())
			.setAddress(students.getAddress())
			.setStateAndCity(students.getState(), students.getCity())
			.clickSubmit()
			.assertSuccessfulText("Thanks for submitting the form")
			.assertSuccessfulList(students.getAll());
	}
}
