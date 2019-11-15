package com.wongnai.interview.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvertedIndex {
    public static Map<String, ArrayList<Long>> invertedIndex = new HashMap<>();

    public InvertedIndex(){}

    public static void putToInvertedIndex(String word, Long movieId){
        if(invertedIndex.get(word) == null){
            invertedIndex.put(word, new ArrayList<>());
            invertedIndex.get(word).add(movieId);
        }
        else{
            if(!invertedIndex.get(word).contains(movieId)){
                invertedIndex.get(word).add(movieId);
            }
        }
    }
}
