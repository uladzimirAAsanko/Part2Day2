package by.sanko.parserproject.entity.impl;

import by.sanko.parserproject.entity.EditedHashMap;
import by.sanko.parserproject.entity.ReCreateText;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements ReCreateText {
    private List<Sentence> components;
    private EditedHashMap uniqWords;

    public Paragraph() {
        components = new ArrayList<>();
        uniqWords = new EditedHashMap();
    }

    public void add(Sentence sentence){
        components.add(sentence);
        uniqWords.putAllFromAnotherMap(sentence.getUniqWords());
    }

    public EditedHashMap getUniqWords() {
        return (EditedHashMap) uniqWords.clone();
    }

    @Override
    public String toText() {
        StringBuilder stringBuilder = new StringBuilder();
        components.forEach((value)->{
            stringBuilder.append(value.toText());
        });
        return stringBuilder.toString();
    }
}
