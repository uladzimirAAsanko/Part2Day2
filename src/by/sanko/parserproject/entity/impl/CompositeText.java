package by.sanko.parserproject.entity.impl;

import by.sanko.parserproject.entity.EditedHashMap;
import by.sanko.parserproject.entity.ReCreateText;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements ReCreateText {

    private List<Paragraph> components;
    private EditedHashMap uniqWords;

    public CompositeText() {
        components = new ArrayList<>();
        uniqWords  = new EditedHashMap();
    }

    public void add(Paragraph paragraph){
        components.add(paragraph);
        uniqWords.putAllFromAnotherMap(paragraph.getUniqWords());
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
