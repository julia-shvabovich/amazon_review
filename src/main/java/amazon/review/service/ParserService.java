package amazon.review.service;

public interface ParserService<T> {
    T parseLine(String line);
}
