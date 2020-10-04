package by.sanko.parserproject.service;

import by.sanko.parserproject.exeption.ServiceException;

import java.util.HashMap;

public interface BookParserServices {

    String readCompleteText() throws ServiceException;

    HashMap computeUniqWords();
}
