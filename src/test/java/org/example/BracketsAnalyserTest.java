package org.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BracketsAnalyserTest {

    private static Stream<Arguments> provideStringsForBracketAnalyser() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("(sd) d ( d[dd] d)", true),
                Arguments.of("{sd} d ( d[dd] d)", true),
                Arguments.of("(sd) d ( d[dd] d) {", false),
                Arguments.of("(({[}{P{{}}{[0))(((((sd d ( d[dd] d) {", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForBracketAnalyser")
    public void whenValidInputStrings_thenReturnValidStatus(String input, Boolean expected) {
        assertThat("Bracket analyser missed match",
                new BracketsAnalyser(CompatiblePairsHolder.getCompatiblePairs())
                        .analyseForBalancedBrackets(input).isBalanced(),
                equalTo(expected));
    }

    @Test
    public void whenNullString_thenReturnException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            new BracketsAnalyser(CompatiblePairsHolder.getCompatiblePairs())
                    .analyseForBalancedBrackets(null).isBalanced();
        });

        String expectedMessage = "Input string shouldn't be null";
        String actualMessage = exception.getMessage();

        assertThat("Expected Exception", actualMessage.equals(expectedMessage));
    }
}