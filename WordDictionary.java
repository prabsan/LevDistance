package com.company;

import java.util.HashSet;
import java.util.Set;

public class WordDictionary {

    public static HashSet<String> getDogDictionary() {
        HashSet<String> dogVariations = new HashSet<String>();
        dogVariations.add("dog");
        dogVariations.add("bog");
        dogVariations.add("cog");
        dogVariations.add("fog");
        dogVariations.add("hog");
        dogVariations.add("jog");
        dogVariations.add("log");
        dogVariations.add("tog");
        dogVariations.add("dig");
        dogVariations.add("dot");
        dogVariations.add("doc");
        dogVariations.add("cot");
        dogVariations.add("dox");
        dogVariations.add("cat");
        dogVariations.add("cod");
        return dogVariations;
     }

    public static HashSet<String> getCarDictionary() {
        HashSet<String> catVariations = new HashSet<String>();
        catVariations.add("bat");
        catVariations.add("fat");
        catVariations.add("gat");
        catVariations.add("hat");
        catVariations.add("mat");
        catVariations.add("pat");
        catVariations.add("cat");
        catVariations.add("sat");
        catVariations.add("tat");
        catVariations.add("vat");
        catVariations.add("cut");
        catVariations.add("cot");
        catVariations.add("cab");
        catVariations.add("can");
        catVariations.add("cap");
        catVariations.add("car");
        return catVariations;
    }
}


