package by.sanko.parserproject.service;

import by.sanko.parserproject.service.impl.BookServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final BookParserServices bookService = new BookServiceImpl();

    private ServiceFactory() {}

    public BookParserServices getBookParserServices() {

        return bookService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
