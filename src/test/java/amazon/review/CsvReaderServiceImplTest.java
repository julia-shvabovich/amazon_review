package amazon.review;

import amazon.review.service.CsvReaderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CsvReaderServiceImplTest {
    private static final String FILE_NAME = "src/main/resources/test.csv";
    private static final String EMPTY_FILE_NAME = "src/main/resources/empty.csv";
    private static final String WRONG_FILE_NAME = "src/main/resources/wrong.csv";

    @Autowired
    private CsvReaderService readerService;

    @Test
    public void readFile() {
        List<String> expected = List.of("1,B001E4KFG0,A3SGXH7AUHU8GW,delmartian" +
                        ",1,1,5,1303862400,Good Quality Dog Food",
                "2,B00813GRG4,A1D87F6ZCVE5NK,dll pa,0,0,1,1346976000,Not as Advertised," +
                        "\"Product arrived labeled as Jumbo Salted Peanuts...\"");
        List<String> result = readerService.read(FILE_NAME);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void readEmptyFile() {
        List<String> result = readerService.read(EMPTY_FILE_NAME);
        Assert.assertEquals(List.of(), result);
    }

    @Test
    public void readWrongPath() {
        assertThrows(RuntimeException.class, () -> readerService.read(WRONG_FILE_NAME));
    }
}
