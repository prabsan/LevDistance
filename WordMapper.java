package com.company;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.List;

public class WordMapper {

    public static HashSet<String> RemoveValidWordsIfRepeated(HashSet<String> newWords, HashSet<String> existingWords) {
        for (String ew : existingWords) {
            if (newWords.contains(ew)) {
                newWords.remove(ew);
            }
        }

        return newWords;
    }

    public static HashSet<String> GetValidWordsFromDictionary(Set<String> dictionary, HashSet<String> words) {
        HashSet<String> validWords = new HashSet<String>();
        for (String s : words) {
            if (dictionary.contains(s)) {
                validWords.add(s);
            }
        }

        return validWords;
    }

    public HashSet<String> BuildNewWords(String currentWord, String targetWord) {
        int length = currentWord.length();
        char[] charArr = currentWord.toCharArray();

        HashSet<String> newWords = new HashSet<String>();

        for (int i = 0; i < length; i++) {
            char original = charArr[i];
            for (char eachC = 'a'; eachC <= 'z'; ++eachC) {
                charArr[i] = eachC;
                String word = new String(charArr);
                newWords.add(word);
                if (word.equals(targetWord)) {
                    break;
                }
            }

            charArr[i] = original;
        }

        return newWords;
    }

    public int EditDistance(String start, String target, HashSet<String> dictionary) {
        if (start.equals(target)) {
            System.out.println("Start and Target words are the same. Level 0");
            return 0;
        }

        int level = 0;
        boolean foundMatch = false;
        HashSet<String> currentGenList = new HashSet<String>();
        HashSet<String> traveresedList = new HashSet<String>();
        currentGenList.add(start);  // dog is added here

        while(!foundMatch) {

            if (currentGenList.contains(target)) {
                foundMatch = true;
                System.out.println("Match is found at level: " + level);
                return level;
            }

            level++;
            HashSet<String> validWords = new HashSet<String>();
            System.out.println();
            System.out.println("Status Update at level: " + level);
            System.out.println("==================================================");
            System.out.println("List of words to be looked up: ");
            System.out.println(currentGenList);

            for (String s : currentGenList) {
                traveresedList.add(s);
                validWords.addAll(BuildNewWords(s, target));
            }

            validWords = GetValidWordsFromDictionary(dictionary, validWords);

            System.out.println("Next generation words: ");
            System.out.println(validWords);
            System.out.println();
            System.out.println("Words after removing already traversed list: ");
            currentGenList = RemoveValidWordsIfRepeated(validWords, traveresedList);
            System.out.println(currentGenList);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        return level;
    }
}
