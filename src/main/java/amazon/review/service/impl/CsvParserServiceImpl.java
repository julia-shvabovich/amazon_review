package amazon.review.service.impl;

import amazon.review.model.dto.ReviewCsvDto;
import amazon.review.service.ParserService;
import com.opencsv.CSVParser;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.stereotype.Service;

@Service
public class CsvParserServiceImpl implements ParserService<ReviewCsvDto> {
    private static final int ID = 0;
    private static final int PRODUCT_ID = 1;
    private static final int USER_ID = 2;
    private static final int PROFILE_NAME = 3;
    private static final int NUMERATOR = 4;
    private static final int DENOMINATOR = 5;
    private static final int SCORE = 6;
    private static final int TIME = 7;
    private static final int SUMMARY = 8;
    private static final int TEXT = 9;

    @Override
    public ReviewCsvDto parseLine(String line) {
        CSVParser csvParser = new CSVParser();
        ReviewCsvDto reviewDto = new ReviewCsvDto();
        try {
            String[] values = csvParser.parseLine(line);
            reviewDto.setId(Long.parseLong(values[ID].trim()));
            reviewDto.setProductId(values[PRODUCT_ID].trim());
            reviewDto.setUserId(values[USER_ID].trim());
            reviewDto.setProfileName(values[PROFILE_NAME].trim());
            reviewDto.setHelpfulnessNumerator(Long.parseLong(values[NUMERATOR].trim()));
            reviewDto.setHelpfulnessDenominator(Long.parseLong(values[DENOMINATOR].trim()));
            reviewDto.setScore(Long.parseLong(values[SCORE].trim()));
            reviewDto.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                    Long.parseLong(values[TIME].trim())), ZoneId.systemDefault()));
            reviewDto.setSummary(values[SUMMARY].trim());
            reviewDto.setText(values[TEXT].trim());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't parse the line " + line, e);
        }
        return reviewDto;
    }
}
