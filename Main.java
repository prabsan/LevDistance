package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        WordMapper wordMap = new WordMapper();

        System.out.println("Test 1 - bat to --> car");
        wordMap.EditDistance("bat", "car", WordDictionary.getCarDictionary());

        System.out.println();
        System.out.println("Test 2 - dog to --> cat");
        wordMap.EditDistance("dog", "cat", WordDictionary.getDogDictionary());
    }
}
