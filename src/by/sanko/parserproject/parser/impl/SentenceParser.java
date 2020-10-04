package by.sanko.parserproject.parser.impl;

import by.sanko.parserproject.entity.ReCreateText;
import by.sanko.parserproject.entity.impl.Sentence;
import by.sanko.parserproject.entity.impl.Word;
import by.sanko.parserproject.parser.BaseParser;

public class SentenceParser implements BaseParser {
    public static final String checkOnPunctuationMarks = ".*\\p{Punct}";
    private Sentence sentence;
    private static final String SPACE = " ";
    private WordParser parser = new WordParser();
    @Override
    public ReCreateText parse(String text) {
        sentence = new Sentence();
        String[] words = text.split(SPACE);
        for(int i = 0; i < words.length; i++){
            if(words[i] != null && !words[i].equals("")) {
                Character endingOfString = words[i].charAt(words[i].length() - 1);
                if (endingOfString.toString().matches(checkOnPunctuationMarks)) {
                    sentence.add((Word) parser.parse(words[i].substring(0, words[i].length() - 1)));
                    sentence.add((Word) parser.parse(endingOfString.toString()));
                } else {
                    sentence.add((Word) parser.parse(words[i]));
                }
            }
        }
        return sentence;
    }
}
