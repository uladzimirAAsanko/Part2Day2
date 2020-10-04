package by.sanko.parserproject.parser.impl;

import by.sanko.parserproject.entity.ReCreateText;
import by.sanko.parserproject.entity.impl.Word;
import by.sanko.parserproject.parser.BaseParser;

public class WordParser implements BaseParser {
    public static final String checkOnPunctuationMarks = ".*\\p{Punct}";
    @Override
    public ReCreateText parse(String text) {
        Word word;
        if(text.matches(checkOnPunctuationMarks)){
            word = new Word(text,true);
        }else{
            word = new Word(text,false);
        }
        return word;
    }
}
