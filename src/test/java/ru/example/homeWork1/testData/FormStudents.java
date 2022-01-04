package ru.example.homeWork1.testData;

import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FormStudents {
	private Faker faker = new Faker();

	private String firstName = faker.name().firstName();
	private String lastName = faker.name().lastName();
	private String userEmail = faker.internet().emailAddress();
	private String userNumber =  "8904117400";
	private String[] genderList = {"Male", "Female", "Other"};
	private String gender = genderList[getRandomNumberUsingNextInt(0, genderList.length)];
	private String dateOfBirth =  "01 May,1993";
	private String[] subjectsList = {"Science", "Math", "Music", "English"};
	private String subjects = subjectsList[getRandomNumberUsingNextInt(0, subjectsList.length)];
	private String[] hobbiesList = {"Sports", "Reading", "Music"};
	private String hobbies = hobbiesList[getRandomNumberUsingNextInt(0, hobbiesList.length)];
	private String pathImage = "src/test/resources/english.jpg";
	private String address = faker.address().streetAddress();
	private String state;
	private String city;

	public FormStudents() {
		Map<String, List<String>> stateAndCityMap= new HashMap<>();
		stateAndCityMap.put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
		stateAndCityMap.put("Haryana", Arrays.asList("Karnal", "Panipat"));
		stateAndCityMap.put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
		stateAndCityMap.put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));

		String[] stateList = stateAndCityMap.keySet().toArray(new String[0]);
		this.state = stateList[getRandomNumberUsingNextInt(0, stateList.length)];

		List<String> cityList = stateAndCityMap.get(this.state);
		this.city = cityList.get(getRandomNumberUsingNextInt(0, cityList.size()));
	}

	private int getRandomNumberUsingNextInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	public ArrayList<String> getAll() {
		String[] path = this.pathImage.split("/");
		ArrayList<String> res = new ArrayList<>();
		res.add(this.firstName);
		res.add(this.lastName);
		res.add(this.userEmail);
		res.add(this.userNumber);
		res.add(this.gender);
		res.add(this.dateOfBirth);
		res.add(this.subjects);
		res.add(this.hobbies);
		res.add(path[path.length - 1]);
		res.add(this.address);
		res.add(String.format("%s %s",this.state, this.city));
		return res;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public String[] getGenderList() {
		return genderList;
	}

	public String getGender() {
		return gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String[] getSubjectsList() {
		return subjectsList;
	}

	public String getSubjects() {
		return subjects;
	}

	public String[] getHobbiesList() {
		return hobbiesList;
	}

	public String getHobbies() {
		return hobbies;
	}

	public String getPathImage() {
		return pathImage;
	}

	public String getAddress() {
		return address;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}
}