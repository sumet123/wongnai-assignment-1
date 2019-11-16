package com.wongnai.interview.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvertedIndex {
    private static Map<String, ArrayList<Long>> invertedIndex;

    public InvertedIndex(){
        invertedIndex = new HashMap<>();
    }

    public void putToInvertedIndex(String word, Long movieId){
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

    public static Map<String, ArrayList<Long>> getInvertedIndex(){
        return invertedIndex;
    }

    public void resetInvertedIndex(){
        invertedIndex = new HashMap<>();
    }
}
