package amazon.review;

import amazon.review.model.Product;
import amazon.review.model.ReviewDto;
import amazon.review.model.mapper.ProductMapper;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductMapperTest {
    private static final ProductMapper productMapper = new ProductMapper();
    private static ReviewDto emptyDto = new ReviewDto();
    private static ReviewDto reviewDtoOk;
    private static ReviewDto reviewDtoWithoutProduct;

    @BeforeAll
    public static void beforeAll() throws Exception {
        reviewDtoOk = new ReviewDto();
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

        reviewDtoWithoutProduct = new ReviewDto();
        reviewDtoWithoutProduct.setId(2L);
        reviewDtoWithoutProduct.setUserId("A1D87F6ZCVE5NK");
        reviewDtoWithoutProduct.setProfileName("dll pa");
        reviewDtoWithoutProduct.setHelpfulnessNumerator(0L);
        reviewDtoWithoutProduct.setHelpfulnessDenominator(0L);
        reviewDtoWithoutProduct.setScore(1L);
        reviewDtoWithoutProduct.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                1346976000L), ZoneId.systemDefault()));
        reviewDtoWithoutProduct.setSummary("Not as Advertised");
        reviewDtoWithoutProduct.setText("Product arrived labeled as Jumbo Salted Peanuts...");
    }

    @Test
    public void mapOk() {
        Product expected = new Product("B001E4KFG0");
        Product actual = productMapper.map(reviewDtoOk);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapEmptyDto() {
        Product expected = new Product();
        Product actual = productMapper.map(emptyDto);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapDtoWithoutProduct() {
        Product expected = new Product();
        Product actual = productMapper.map(reviewDtoWithoutProduct);
        Assert.assertEquals(expected, actual);
    }
}
