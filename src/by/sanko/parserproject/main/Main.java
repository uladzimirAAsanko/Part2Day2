package by.sanko.parserproject.main;

import by.sanko.parserproject.exeption.ServiceException;
import by.sanko.parserproject.service.BookParserServices;
import by.sanko.parserproject.service.ServiceFactory;
import by.sanko.parserproject.service.impl.BookServiceImpl;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ServiceFactory factory = ServiceFactory.getInstance();
        BookParserServices bookService = factory.getBookParserServices();
        try {
            System.out.println(bookService.readCompleteText());
            HashMap map = bookService.computeUniqWords();
            map.forEach((key,value)->{
                System.out.println(value + " " + key);
            });
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
