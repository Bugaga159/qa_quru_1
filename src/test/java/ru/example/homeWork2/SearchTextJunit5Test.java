package ru.example.homeWork2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTextJunit5Test {
	@BeforeAll
	static void setup() {
		Configuration.baseUrl = "https://github.com";
		Configuration.browserSize = "1920x1080";
	}

	@Test
	public void shouldBeTextJunit5() {
		open("/selenide/selenide");
		$x("//*[@data-content='Wiki']").click();
		$(".wiki-more-pages-link button").click();
		$(byText("SoftAssertions")).click();
		$$(".markdown-body li").filterBy(text("Using JUnit5 extend test class:"))
				.first().shouldBe(visible);
	}
}
