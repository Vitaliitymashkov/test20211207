package org.example;

import java.util.HashMap;
import java.util.Map;

public class CompatiblePairsHolder {

    private final static HashMap<Character, Character> compatiblePairs = new HashMap<>();

    public static Map<Character, Character> getCompatiblePairs() {
        compatiblePairs.put('(', ')');
        compatiblePairs.put('{', '}');
        compatiblePairs.put('[', ']');
        return compatiblePairs;
    }
}
