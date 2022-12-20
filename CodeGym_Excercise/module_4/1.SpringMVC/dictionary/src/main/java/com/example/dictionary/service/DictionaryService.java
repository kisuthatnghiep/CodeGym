package com.example.dictionary.service;

import java.util.HashMap;

public class DictionaryService {
    private static HashMap<String,String> dictionary;
    static {
        dictionary = new HashMap<>();
        dictionary.put("cat", "mèo");
        dictionary.put("dog", "chó");
        dictionary.put("fish", "cá");
    }
    public String findValue(String word){
        return dictionary.get(word);
    }
}
