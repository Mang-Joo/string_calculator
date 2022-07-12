package StringCalculator.string_calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatingMachineTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 / 5=1",
            "1 * 1=1",
            "0 * 0=0",
            "0 / 1=0",
            "0 - 1=-1",
            "15 - 1=14",
            "1=1",
    }, delimiter = '=')
    void 연산_테스트(String expression, int result) {
        CalculatingMachine calculatingMachine = new CalculatingMachine(new ArithmeticExpression(expression));
        assertThat(calculatingMachine.calculator()).isEqualTo(result);
    }
}
