package amazon.review;

import amazon.review.model.Review;
import amazon.review.model.dto.ReviewCsvDto;
import amazon.review.model.mapper.ReviewMapper;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewMapperTest {
    private static ReviewMapper reviewMapper = new ReviewMapper();
    private static ReviewCsvDto emptyDto = new ReviewCsvDto();
    private static ReviewCsvDto reviewDtoOk = new ReviewCsvDto();

    @BeforeAll
    public static void beforeAll() throws Exception {
        reviewMapper = new ReviewMapper();
        reviewDtoOk = new ReviewCsvDto();
        reviewDtoOk.setId(1L);
        reviewDtoOk.setProductId("B001E4KFG0");
        reviewDtoOk.setUserId("A3SGXH7AUHU8GW");
        reviewDtoOk.setProfileName("delmartian");
        reviewDtoOk.setHelpfulnessNumerator(1L);
        reviewDtoOk.setHelpfulnessDenominator(1L);
        reviewDtoOk.setScore(5L);
        reviewDtoOk.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                1303862400L), ZoneId.systemDefault()));
        reviewDtoOk.setSummary("Good Quality Dog Food");
        reviewDtoOk.setText("I have bought several of the Vitality canned dog food products");
    }

    @Test
    public void mapDtoOk() {
        Review expected = new Review();
        expected.setHelpfulnessNumerator(1L);
        expected.setHelpfulnessDenominator(1L);
        expected.setScore(5L);
        expected.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                1303862400L), ZoneId.systemDefault()));
        expected.setSummary("Good Quality Dog Food");
        expected.setText("I have bought several of the Vitality canned dog food products");
        Review actual = reviewMapper.mapToReview(reviewDtoOk);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapEmptyOk() {
        Review expected = new Review();
        Review actual = reviewMapper.mapToReview(emptyDto);
        Assert.assertEquals(expected, actual);
    }
}
