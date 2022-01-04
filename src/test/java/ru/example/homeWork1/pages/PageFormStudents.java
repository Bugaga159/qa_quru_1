package ru.example.homeWork1.pages;

import com.codeborne.selenide.SelenideElement;
import java.io.File;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PageFormStudents {
	private SelenideElement firstName = $("#firstName");
	private SelenideElement lastName = $("#lastName");
	private SelenideElement userEmail = $("#userEmail");
	private SelenideElement userNumber = $("#userNumber");
	private SelenideElement gender = $("#genterWrapper");
	private SelenideElement subjectsInput = $("#subjectsInput");
	private SelenideElement hobbies = $("#hobbiesWrapper");
	private SelenideElement uploadPicture = $("#uploadPicture");
	private SelenideElement address = $("#currentAddress");
	private SelenideElement submit = $("#submit");
	private SelenideElement successfulText = $("#example-modal-sizes-title-lg");
	private SelenideElement successfulList = $(".table-responsive");

	public PageFormStudents setFirstName(String firstName) {
		this.firstName.setValue(firstName);
		return this;
	}

	public PageFormStudents setLastName(String lastName) {
		this.lastName.setValue(lastName);
		return this;
	}

	public PageFormStudents setUserEmail(String userEmail) {
		this.userEmail.setValue(userEmail);
		return this;
	}

	public PageFormStudents setUserNumber(String userNumber) {
		this.userNumber.setValue(userNumber);
		return this;
	}

	public PageFormStudents setGender(String gender) {
		this.gender.$(byText(gender)).click();
		return this;
	}

	public PageFormStudents setBirthDay() {
		$("#dateOfBirthInput").click();
		$(".react-datepicker__month-select").selectOption("May");
		$(".react-datepicker__year-select").selectOption("1993");
		$(".react-datepicker__day--001").click();
		return this;
	}

	public PageFormStudents setSubject(String subjectsInput) {
		this.subjectsInput.setValue(subjectsInput).pressEnter();
		return this;
	}

	public PageFormStudents setHobbies(String hobbies) {
		this.hobbies.$(byText(hobbies)).click();
		return this;
	}

	public PageFormStudents setUploadPicture(String path) {
		this.uploadPicture.uploadFile(new File(path));
		return this;
	}

	public PageFormStudents setAddress(String address) {
		this.address.setValue(address);
		return this;
	}

	public PageFormStudents setStateAndCity(String state, String city) {
		$("#react-select-3-input").setValue(state).pressEnter();
		$("#react-select-4-input").setValue(city).pressEnter();
		return this;
	}

	public PageFormStudents clickSubmit() {
		this.submit.scrollTo().click();
		return this;
	}

	public PageFormStudents assertSuccessfulText(String successfulText) {
		this.successfulText.shouldHave(text(successfulText));
		return this;
	}

	public PageFormStudents assertSuccessfulList(ArrayList<String> list) {
		list.forEach(el -> this.successfulList.shouldHave(text(el)));
		return this;
	}
}
