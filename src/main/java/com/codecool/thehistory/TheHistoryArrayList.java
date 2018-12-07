package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Arrays;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        List<String> textAsList = Arrays.asList(text.split(" "));
        wordsArrayList.addAll(textAsList);

    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        ListIterator<String> iterator = wordsArrayList.listIterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if(word.equals(wordToBeRemoved)) {
                iterator.remove();
            }
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information

        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        Collections.replaceAll(wordsArrayList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String from = String.join(" ", fromWords).trim();
        String to = String.join(" ", toWords).trim();
        String arrayAsString = toString();
        String textWithReplacedWords = arrayAsString.replaceAll(from, to);
        wordsArrayList = new ArrayList<>(Arrays.asList(textWithReplacedWords.split(" ")));
}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
