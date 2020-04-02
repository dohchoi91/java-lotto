package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FormulaTest {

    @ParameterizedTest
    @CsvSource(value = {"1,-2,3,4 -> ,", "1,ㄱ,3,4 -> ,", "1,-2,3,ㄱ -> ,"}, delimiterString = " -> ")
    @DisplayName("잘못된 계산식(문자, 음수) 테스트")
    void validateTest(String input, String splitSeparators) {
        assertThatThrownBy(
                () -> new Formula(input, splitSeparators)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4 -> , -> 10", "7,5,3,1 -> , -> 16", "8#1#2#5 -> # -> 16"}, delimiterString = " -> ")
    @DisplayName("전체 더하기 테스트")
    void sumTest(String input, String splitSeparators, int result) {
        assertThat(
                new Formula(input, splitSeparators).sum()
        ).isEqualTo(result);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("계산식이 공백일때 0반환 테스트")
    void sumTest(String input) {
        assertThat(
                new Formula(input, ",").sum()
        ).isEqualTo(0);
    }
}
