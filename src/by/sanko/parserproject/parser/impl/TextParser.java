package by.sanko.parserproject.parser.impl;

import by.sanko.parserproject.entity.ReCreateText;
import by.sanko.parserproject.entity.impl.CompositeText;
import by.sanko.parserproject.entity.impl.Paragraph;
import by.sanko.parserproject.entity.impl.Sentence;
import by.sanko.parserproject.parser.BaseParser;

public class TextParser implements BaseParser {
    private ParagraphParser paragraphParser = new ParagraphParser();
    private static final  String PARAGRAPH_DELIMETR = "(?m)(?=^\\s{4})";
    @Override
    public ReCreateText parse(String text) {
        String[] paragraphs = text.split(PARAGRAPH_DELIMETR);
        CompositeText fullText = new CompositeText();
        for(int i = 0; i < paragraphs.length; i++){
            fullText.add((Paragraph) paragraphParser.parse(paragraphs[i].trim()));
        }
        return fullText;
    }
}
