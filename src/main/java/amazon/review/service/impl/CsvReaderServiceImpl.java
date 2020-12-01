package amazon.review.service.impl;

import amazon.review.service.CsvReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CsvReaderServiceImpl implements CsvReaderService {
    @Override
    public List<String> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read data from " + filePath, e);
        }
    }
}
