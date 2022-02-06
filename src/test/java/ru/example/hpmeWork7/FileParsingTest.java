package ru.example.hpmeWork7;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static org.assertj.core.api.Assertions.assertThat;

public class FileParsingTest {

	private ClassLoader cl = FileParsingTest.class.getClassLoader();

	@Test
	void parsePdfTest() throws Exception {
		Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
		File pdfDownload = Selenide.$(byText("PDF download")).download();
		PDF parsed = new PDF(pdfDownload);
		assertThat(parsed.author).contains("Marc Philipp");
	}

    @Test
    void parseXlsTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("test.xlsx")) {
            XLS parsed = new XLS(stream);
            assertThat(parsed.excel.getSheet("Sheet1")
				.getRow(0).getCell(0).getStringCellValue())
				.isEqualTo("test");
        }
    }

	@Test
	void parseCsvFile() throws Exception {
		try (InputStream stream = cl.getResourceAsStream("example.csv")) {
			CSVReader reader = new CSVReader(new InputStreamReader(stream));
			List<String[]> list = reader.readAll();
			assertThat(list)
				.hasSize(3)
				.contains(
					new String[] {"Author", "Book"},
					new String[] {"Block", "Apteka"},
					new String[] {"Esenin", "Cherniy Chelovek"}
				);
		}
	}

	@Test
	void zipTest() throws Exception {
		try (InputStream stream = cl.getResourceAsStream("archive.zip");
			 ZipInputStream zis = new ZipInputStream(stream)) {
			ZipEntry zipEntry;
			while ((zipEntry = zis.getNextEntry()) != null) {
				assertThat(zipEntry.getName()).isEqualTo("test.xlsx");
			}
		}
		ZipFile zf = new ZipFile(new File(cl.getResource("archive.zip").toURI()));
	}
}
