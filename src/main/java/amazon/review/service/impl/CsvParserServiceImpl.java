package amazon.review.service.impl;

import amazon.review.model.dto.ReviewCsvDto;
import amazon.review.service.ParserService;
import com.opencsv.CSVParser;
import java.io.IOException;
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
        ReviewCsvDto reviewCsvDto = new ReviewCsvDto();
        try {
            String[] values = csvParser.parseLine(line);
            reviewCsvDto.setId(Long.parseLong(values[ID].trim()));
            reviewCsvDto.setProductId(values[PRODUCT_ID].trim());
            reviewCsvDto.setUserId(values[USER_ID].trim());
            reviewCsvDto.setProfileName(values[PROFILE_NAME].trim());
            reviewCsvDto.setHelpfulnessNumerator(Integer.parseInt(values[NUMERATOR].trim()));
            reviewCsvDto.setHelpfulnessDenominator(Integer.parseInt(values[DENOMINATOR].trim()));
            reviewCsvDto.setScore(Integer.parseInt(values[SCORE].trim()));
            reviewCsvDto.setTime(Long.parseLong(values[TIME].trim()));
            reviewCsvDto.setSummary(values[SUMMARY].trim());
            reviewCsvDto.setText(values[TEXT].trim());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't parse the line " + line, e);
        }
        return reviewCsvDto;
    }
}
