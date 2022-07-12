package StringCalculator.string_calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource
    void 두자리이상_숫자_정규식_테스트(String expression, String[] result) {
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(expression);
        String[] number = arithmeticExpression.getExpression()
                .replaceAll("\\D", ",")
                .split(",");
        assertThat(number).isEqualTo(result);
    }

    public static Stream<Arguments> 두자리이상_숫자_정규식_테스트() {
        return Stream.of(
                Arguments.of("15 - 1", new String[]{"15", "1"}),
                Arguments.of("20 - 1 + 150", new String[]{"20", "1", "150"})
        );
    }


}
