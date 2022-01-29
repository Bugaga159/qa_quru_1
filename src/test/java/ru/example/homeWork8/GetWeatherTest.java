package ru.example.homeWork8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GetWeatherTest {
	@BeforeEach
	void openPage() {
		open("https://yandex.ru/pogoda");
		$(".yandex-header__logo a").shouldBe(visible);
	}

	@AfterEach
	void closePage() {
		closeWebDriver();
	}

	@Test
	@Disabled("Нужно поправить данные")
	void disabledTest(){
		System.out.println("Нужно поправить данные");
	}

	@ValueSource(strings = {"Москва", "Калининград", "Сочи"})
	@ParameterizedTest(name = "Тест с параметром: {0}")
	void testWithParams(String testData) {
		$x("//input[contains(@class,'mini-suggest-form__input')]").setValue(testData).pressEnter();
		$(".place-list__item a").shouldBe(text(testData)).click();
		$x("(//span[@class='breadcrumbs__title'])[last()]").shouldBe(text(testData));
	}

	@CsvSource(value = {
			"Москва, Москва и Московская область",
			"Калининград, Калининградская область",
			"Сочи, Краснодарский край"
	})
	@ParameterizedTest(name = "Тест с двумя параметрами {0} > {1}")
	void testWithCSVParams(String city, String area) {
		$x("//input[contains(@class,'mini-suggest-form__input')]").setValue(city).pressEnter();
		$(".place-list__item a").shouldBe(text(city)).click();
		$x("(//span[@class='breadcrumbs__title'])[last()]").shouldBe(text(city));
		$x("(//span[@class='breadcrumbs__title'])[2]").shouldBe(text(area));
	}

	static Stream<Arguments> commonSearchTestDataProvider(){
		return Stream.of(
				Arguments.of("Москва", "Москва и Московская область"),
				Arguments.of("Калининград", "Калининградская область")
		);
	}

	@MethodSource("commonSearchTestDataProvider")
	@ParameterizedTest(name = "Тест с параметрами {0} > {1}")
	void testWithMethodSource(String city, String area) {
		$x("//input[contains(@class,'mini-suggest-form__input')]").setValue(city).pressEnter();
		$(".place-list__item a").shouldBe(text(city)).click();
		$x("(//span[@class='breadcrumbs__title'])[last()]").shouldBe(text(city));
		$x("(//span[@class='breadcrumbs__title'])[2]").shouldBe(text(area));
	}
}
