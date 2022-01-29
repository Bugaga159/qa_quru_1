package ru.example.homeWork6;

import org.junit.jupiter.api.Test;
import ru.example.homeWork6.pages.GitHubPage;

public class StepsAnnotationInTest extends BaseTest{

	@Test
	public void findIssueIdByAnnotation() {
		GitHubPage page = new GitHubPage();
		page.openPage("https://github.com")
			.searchRepository("eroshenkoam/allure-example")
			.selectRepository("eroshenkoam/allure-example")
			.selectIssues()
			.assertIssueId(68);
	}
}
