package amazon.review;

import static org.junit.jupiter.api.Assertions.assertThrows;

import amazon.review.model.dto.ReviewCsvDto;
import amazon.review.service.CsvReaderService;
import amazon.review.service.ParserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CsvParserServiceImplTest {
    private static final String FILE_NAME = "src/main/resources/one_line.csv";
    private static final String WRONG_FORMAT = "src/main/resources/wrong_format.csv";

    @Autowired
    private CsvReaderService readerService;
    @Autowired
    private ParserService csvParserService;

    @Test
    public void parseOkLine() {
        ReviewCsvDto expectedDto = new ReviewCsvDto();
        expectedDto.setId(1L);
        expectedDto.setProductId("B001E4KFG0");
        expectedDto.setUserId("A3SGXH7AUHU8GW");
        expectedDto.setProfileName("delmartian");
        expectedDto.setHelpfulnessNumerator(1);
        expectedDto.setHelpfulnessDenominator(1);
        expectedDto.setScore(5);
        expectedDto.setTime(1303862400L);
        expectedDto.setSummary("Good Quality Dog Food");
        expectedDto.setText("I have bought several of the Vitality canned dog food products"
                + " and have found them all to be of good quality.");
        String line = readerService.read(FILE_NAME).get(0);
        Assert.assertEquals(expectedDto, csvParserService.parseLine(line));
    }

    @Test
    public void parseWrongFormatLine() {
        assertThrows(RuntimeException.class, () -> {
            csvParserService.parseLine(readerService.read(WRONG_FORMAT).get(0));
        });
    }

    @Test
    public void parseEmptyLine() {
        assertThrows(RuntimeException.class, () -> {
            csvParserService.parseLine(null);
        });
    }
}
