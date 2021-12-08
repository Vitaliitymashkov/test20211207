package org.example;

import java.util.Stack;

public class ResultPrinter {
    public void printResult(String input, Boolean isBalanced) {
        System.out.println(input + (isBalanced ? " is balanced" : " is unbalanced"));
    }
}
