package by.sanko.parserproject.entity.impl;

import by.sanko.parserproject.entity.EditedHashMap;
import by.sanko.parserproject.entity.ReCreateText;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements ReCreateText {
    private List<Word> components;
    private EditedHashMap uniqWords;

    public Sentence() {
        components = new ArrayList<>();
        uniqWords = new EditedHashMap();
    }

    public void add(Word word){
        components.add(word);
        uniqWords.put(word,1);
    }

    public EditedHashMap getUniqWords() {
        return (EditedHashMap) uniqWords.clone();
    }

    @Override
    public String toText() {
        StringBuilder sb = new StringBuilder();
        components.forEach((value)->{
            sb.append(value.toText());
        });
        return sb.toString();
    }
}
