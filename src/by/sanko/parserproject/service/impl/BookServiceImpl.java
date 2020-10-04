package by.sanko.parserproject.service.impl;

import by.sanko.parserproject.entity.ReCreateText;
import by.sanko.parserproject.entity.impl.CompositeText;
import by.sanko.parserproject.exeption.ReaderException;
import by.sanko.parserproject.exeption.ServiceException;
import by.sanko.parserproject.parser.impl.TextParser;
import by.sanko.parserproject.reader.ReaderFactory;
import by.sanko.parserproject.reader.ReaderFromFile;
import by.sanko.parserproject.service.BookParserServices;

import java.util.HashMap;

public class BookServiceImpl implements BookParserServices {
    private ReCreateText compositeText = null;

    @Override
    public String readCompleteText() throws ServiceException {
        ReaderFromFile reader =  ReaderFactory.getInstance().getReaderFromFile();
        TextParser parser = new TextParser();
        try {
            String answer = reader.read();
            System.out.println(answer);
            compositeText = parser.parse(answer);
        } catch (ReaderException e) {
            throw new ServiceException(e);
        }
        return compositeText.toText();
    }

    @Override
    public HashMap computeUniqWords() {
        CompositeText compositeText1 = (CompositeText) compositeText;
        return compositeText1.getUniqWords();
    }
}
