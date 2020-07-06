package com.codecool.thehistory;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String regex = "\\w+";
        if (wordsArray.length == 0) {
            wordsArray = text.split("\\W+");
        } else {
            StringBuilder temp = new StringBuilder();
            for (String s : wordsArray) {
                if (Pattern.matches(regex, s)) {
                    temp.append(s).append(" ");
                }
            }
            temp.append(text);
            wordsArray = temp.toString().split(" ");
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        if (wordsArray.length > 0) {
            StringBuilder temp = new StringBuilder();
            for (String word : wordsArray) {
                if (!word.equals(wordToBeRemoved)) {
                    temp.append(word);
                    temp.append(" ");
                }
            }
            wordsArray = temp.toString().split(" ");
        }


    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        int counter = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            counter++;
        }
        return counter;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        if (wordsArray.length > 0) {
            StringBuilder temp = new StringBuilder();
            for (String word : wordsArray) {
                if (word.equals(from)) {
                    temp.append(to);
                } else {
                    temp.append(word);
                }
                temp.append(" ");
            }
            wordsArray = temp.toString().split(" ");
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String from = Stream.of(fromWords)
                .map(String::new)
                .collect(Collectors.joining(" "));
        String to = Stream.of(toWords)
                .map(String::new)
                .collect(Collectors.joining(" "));
        String arr = Stream.of(wordsArray)
                .map(String::new)
                .collect(Collectors.joining(" "));
        wordsArray = arr.replaceAll(Pattern.quote(from), to).split(" ");



    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
