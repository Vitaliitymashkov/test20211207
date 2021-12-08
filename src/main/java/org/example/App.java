package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Start");
        String input = "(sd) d ( d[dd] d) {";
//        String input = "(sd) d ( d[dd] d)";

        new ResultPrinter().printResult(input,
                new BracketsAnalyser(CompatiblePairsHolder.getCompatiblePairs())
                        .analyseForBalancedBrackets(input)
                        .isBalanced());
    }
}
