package ru.example.homeWork1.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.example.homeWork1.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

	@BeforeAll
	static void setup() {
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		String login = System.getProperty("login");
		String pass = System.getProperty("pass");
		String url = System.getProperty("url");

		Configuration.baseUrl = "https://demoqa.com";
		Configuration.browserSize = "1920x1080";
		Configuration.browser = System.getProperty("browser", "chrome");
		Configuration.browserVersion = System.getProperty("version", "91");
		Configuration.remote = String.format("https://%s:%s@%s/wd/hub", login, pass, url);
//	"https://user1:1234@selenoid.autotests.cloud/wd/hub";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("enableVideo", true);
		Configuration.browserCapabilities = capabilities;
	}

	@AfterEach
	void addAttachments() {
		Attach.screenshotAs("Last screenshot");
		Attach.pageSource();
		Attach.browserConsoleLogs();
		Attach.addVideo();
		closeWebDriver();
	}
}
