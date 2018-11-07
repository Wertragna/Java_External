package com.Task2;

import java.util.ArrayList;
import java.util.List;

public class Word implements PunctuationOrWord {
    List<Symbol> word;

    public Word(List<Symbol> word) {
        this.word = word;
    }

    public Word(String wordOfText) {
        this.word = new ArrayList<>();
        for(char c:wordOfText.toCharArray()){
            word.add(new Symbol(c));
        }
    }

    public List<Symbol> getWord() {
        return word;
    }

    public Symbol getFirstSymbol() {
        return word.get(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(word.size());
        for(Symbol c: word){
            res.append(c.getSymbol());
        }
        return res.toString();
    }
}
