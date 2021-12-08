package org.example;

import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

public class BracketsAnalyser {
    private final Map<Character, Character> compatiblePairs;
    private final Stack<Character> parser;

    public BracketsAnalyser(Map<Character, Character> compatiblePairs) {
        checkCompatiblePairsCollection(compatiblePairs);
        this.compatiblePairs = compatiblePairs;
        parser = new Stack<>();
    }

    public BracketsAnalyser analyseForBalancedBrackets(String input) {
        checkAndThrowExceptionIfFalse(null == input, "Input string shouldn't be null");
        IntStream.range(0, input.length())
                .mapToObj(input::charAt)
                .forEach(this::parseCharacter);
        return this;
    }

    public Boolean isBalanced() {
        return parser.empty();
    }

    private void parseCharacter(Character character) {
        if (compatiblePairs.containsKey(character)) {
            parser.push(character);
        } else if (compatiblePairs.containsValue(character) && (character.equals(compatiblePairs.get(parser.peek())))) {
            parser.pop();
        }
    }

    private void checkCompatiblePairsCollection(Map<Character, Character> compatiblePairs) {
        checkAndThrowExceptionIfFalse(compatiblePairs.isEmpty(), "Compatible Pairs collection shouldn't be empty");
    }

    private void checkAndThrowExceptionIfFalse(boolean checkResult, String runtimeExceptionMessage) {
        if (checkResult) {
            throw new RuntimeException(runtimeExceptionMessage);
        }
    }
}
