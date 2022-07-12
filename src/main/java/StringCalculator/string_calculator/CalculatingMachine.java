package StringCalculator.string_calculator;

import java.util.*;

public class CalculatingMachine {

    private final ArithmeticExpression arithmeticExpression;

    public CalculatingMachine(ArithmeticExpression arithmeticExpression) {
        this.arithmeticExpression = arithmeticExpression;
    }

    public int calculator() {

        Queue<String> stringQueue = new LinkedList<>();
        Queue<String> numberQueue = new LinkedList<>();

        String[] number = arithmeticExpression.getExpression()
                .replaceAll("\\D", ",")
                .split(",");

        String[] operator = arithmeticExpression.getExpression()
                .replaceAll("\\d", "")
                .split("");

        Collections.addAll(stringQueue, operator);
        Collections.addAll(numberQueue, number);

        int sum = Integer.parseInt(Objects.requireNonNull(numberQueue.poll()));

        while (!stringQueue.isEmpty() && !numberQueue.isEmpty()) {
            int num = Integer.parseInt(numberQueue.poll());
            String poll = stringQueue.poll();

            switch (poll) {
                case "+" -> {
                    sum = sum(sum, num);
                }
                case "-" -> {
                    sum = minus(sum, num);
                }
                case "*" -> {
                    sum = multiply(sum, num);
                }
                case "/" -> {
                    sum = dividing(sum, num);
                }
            }
        }

        return sum;
    }

    private int sum(int num1, int num2) {
        return num1 + num2;
    }

    private int minus(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int dividing(int num1, int num2) {
        return num1 / num2;
    }


}
