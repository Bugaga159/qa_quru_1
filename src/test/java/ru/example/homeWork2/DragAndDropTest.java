package ru.example.homeWork2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
	@BeforeAll
	static void setup() {
		Configuration.browserSize = "1920x1080";
	}

	@Test
	public void dragAndDropElement() {
		open("https://the-internet.herokuapp.com/drag_and_drop");
		SelenideElement blockA = $("#column-a");
		SelenideElement blockB = $("#column-b");
		blockA.dragAndDropTo(blockB);
		blockB.shouldHave(text("A"));
		blockA.shouldHave(text("B"));
	}
}
