package by.sanko.parserproject.parser.impl;

import by.sanko.parserproject.entity.ReCreateText;
import by.sanko.parserproject.entity.impl.Paragraph;
import by.sanko.parserproject.entity.impl.Sentence;
import by.sanko.parserproject.parser.BaseParser;

public class ParagraphParser implements BaseParser {
    private SentenceParser sentenceParser = new SentenceParser();
    private static final String SENTENCE_DELIMETER = "(?<=[^ ]\\.) (?=[^a-z])";
    @Override
    public ReCreateText parse(String text) {
        String[] sentences = text.split(SENTENCE_DELIMETER);
        Paragraph paragraph = new Paragraph();
        for(int i = 0; i < sentences.length; i++){
            paragraph.add((Sentence)sentenceParser.parse(sentences[i]));
        }
        return paragraph;
    }
}
