package by.sanko.parserproject.entity.impl;

import by.sanko.parserproject.entity.ReCreateText;

import java.util.Objects;

public class Word implements ReCreateText {
    private String word;
    private boolean isPunctuation;

    public Word(String word, boolean isPunctuation) {
        this.word = word;
        this.isPunctuation = isPunctuation;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return isPunctuation == word1.isPunctuation &&
                word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + word != null ? word.hashCode() : 0;
        return result;
    }

    @Override
    public String toText() {
        if(isPunctuation){
            return word;
        }
        return " " + word;
    }
}
