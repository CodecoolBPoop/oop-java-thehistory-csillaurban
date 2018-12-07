package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information

        String[] textArray = text.split(" ");
        String[] containerArray = Arrays.copyOf(wordsArray, wordsArray.length + textArray.length);
        System.arraycopy(textArray, 0, containerArray, wordsArray.length, textArray.length);
        wordsArray = containerArray;
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information

        String textAsString = String.join(" ", wordsArray) + " ";
        String wordRemove = textAsString.replaceAll(wordToBeRemoved + " ", "").trim();
        wordsArray = wordRemove.split(" ");
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information

        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        String textAsString = String.join(" ", wordsArray);
        String textWithReplace = textAsString.replaceAll(from, to);
        wordsArray = textWithReplace.split(" ");
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String from = String.join(" ", fromWords).trim();
        String to = String.join(" ", toWords).trim();
        String textAsString = String.join(" ", wordsArray);
        String textWithReplaceWords = textAsString.replaceAll(from, to);
        wordsArray = textWithReplaceWords.split(" ");
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
