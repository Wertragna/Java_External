package com.Task2;

import java.io.IOException;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args ){
        try {
            TextProcessor textProcessor = new TextProcessor("data/text.txt");
            textProcessor.writeSortedWords();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
