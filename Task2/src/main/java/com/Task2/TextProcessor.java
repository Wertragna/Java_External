package com.Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextProcessor {
    private String text;
    private List<Word> words;
    public TextProcessor(String filepath) throws IOException {
        File file = new File(filepath);
        text = readFile(filepath);
        words = new ArrayList<>();
        splitText();

    }

    String readFile(String filepath) throws IOException {
        File file = new File(filepath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder= new StringBuilder();
        String line;
        while ((line= bufferedReader.readLine())!=null)
            stringBuilder.append(line);
        String text=stringBuilder.toString();
        bufferedReader.close();
        return text;

    }

    void splitText(){
        String[] splittedText = text.split("[\\s;;.,\"{}()]");
        for(String s:splittedText){
            if(s.equals(""))
                continue;
            words.add(new Word(s));
        }
    }

    List<Word> sortedByFirstLetter(){
        List<Word> sortedWords = new ArrayList<>(words);
        sortedWords.sort(Comparator.comparing(a->Character.toLowerCase( a.getFirstSymbol().getSymbol())));
        return sortedWords;
    }

    public void writeSortedWords() throws IOException {
        List<Word> list = sortedByFirstLetter();
        BufferedWriter writer = new BufferedWriter(new FileWriter("data/result.txt"));
        boolean redline = true;
        char letter= 0;
        if(!list.isEmpty())
            letter = Character.toLowerCase( list.get(0).getFirstSymbol().getSymbol());
        for (Word word:list) {
            if(!Character.isLetter(word.getFirstSymbol().getSymbol()))
                continue;
            if(Character.toLowerCase(word.getFirstSymbol().getSymbol())!=letter){
                redline = true;
                letter = Character.toLowerCase( word.getFirstSymbol().getSymbol());
            }
            if(redline){
                writer.write("\t"+word+"\n");
            } else {
                writer.write(word+"\n");
            }
            redline = false;
        }
        writer.close();
    }

}
