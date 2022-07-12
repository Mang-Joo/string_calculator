package StringCalculator.string_calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ArithmeticExpressionTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "2 + 3 / 5",
            "1 * 1",
            "0 * 0",
            "0 / 1",
            "0 - 1",
            "1"
    })
    void 올바른_사칙연산일_경우_예외가_발생하지_않는다(String expression) {
        assertThatCode(() -> new ArithmeticExpression(expression))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "-1",
            "1 + 1 + ",
            "1 + 1 + + 1",
            "+ + 1",
            "+ +",
            "1 1"
    })
    void 올바르지_않은_사칙연산일_경우_예외가_발생한다(String expression) {
        assertThatThrownBy(() -> new ArithmeticExpression(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 연산입니다.");
    }

    @Test
    void 숫자를_0으로_나누면_예외가_발생한다() {
        String expression = "0 / 0";
        assertThatThrownBy(() -> new ArithmeticExpression(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2 + 3 / 5",
            "1 * 1",
            "0 * 0",
            "0 / 1",
            "0 - 1",
            "1",
            "24 + 3"
    })
    void 정규식_테스트(String expression) {

        assertThat(expression.matches("^?\\d+( ?[*\\-+/] ?\\d)*$")).isEqualTo(true);
    }
}