package by.sanko.parserproject.reader;

public class ReaderFactory {
    private static final ReaderFactory instance = new ReaderFactory();
    private final ReaderFromFile readerFromFile = new ReaderFromFile();

    private ReaderFactory(){};

    public ReaderFromFile getReaderFromFile() {
        return readerFromFile;
    }

    public static ReaderFactory getInstance() {
        return instance;
    }
}
