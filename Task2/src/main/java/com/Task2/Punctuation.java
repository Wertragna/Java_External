package com.Task2;

public class Punctuation extends Symbol implements PunctuationOrWord {
    public Punctuation(char symbol) {
        super(symbol);
        if (!isPunctuation(symbol))
            throw new IllegalArgumentException(symbol+"isn`n punctuation");
    }
    private boolean isPunctuation(char symbol){
        if("\";;.,{}()".indexOf(symbol)!=-1)
            return true;
        else
            return false;
    }

}
