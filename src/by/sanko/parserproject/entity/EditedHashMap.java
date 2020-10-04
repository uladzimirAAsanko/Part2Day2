package by.sanko.parserproject.entity;

import by.sanko.parserproject.entity.impl.Word;

import java.util.HashMap;
import java.util.Map;

public class EditedHashMap extends HashMap<Word,Integer> {

    @Override
    public Integer put(Word key, Integer value) {
        if(this.containsKey(key)){
            Integer oldValue = this.get(key);
            int currentValue = value + oldValue;
            this.replace(key,oldValue,currentValue);
            return currentValue;
        }else {
            return super.put(key, value);
        }
    }

    public void putAllFromAnotherMap(HashMap<Word,Integer> m) {
        m.forEach(this::put);
    }
}
