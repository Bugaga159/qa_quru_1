package ru.example.hpmeWork7;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFilesTest {

	@Test
	public void downloadTest() throws IOException {
		Selenide.open("https://github.com/junit-team/junit5/blob/main/LICENSE.md");
		File file = $("#raw-url").download();
		try(InputStream is = new FileInputStream(file)) {
			assertThat(new String(is.readAllBytes(), StandardCharsets.UTF_8))
				.contains("Eclipse Public License");
		}
	}

	@Test
	void uploadFile() {
		Selenide.open("https://the-internet.herokuapp.com/upload");
		Selenide.$("input[type='file']").uploadFromClasspath("upload.txt");
		Selenide.$("#file-submit").click();
		Selenide.$("#uploaded-files").shouldHave(Condition.text("upload.txt"));
	}
}
