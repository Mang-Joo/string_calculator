package StringCalculator.string_calculator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CalculatingMachine {

    private final ArithmeticExpression arithmeticExpression;

    public CalculatingMachine(ArithmeticExpression arithmeticExpression) {
        this.arithmeticExpression = arithmeticExpression;
    }

    public int calculator() {

        Queue<String> stringQueue = new LinkedList<>();
        Queue<String> numberQueue = new LinkedList<>();

        String[] number = arithmeticExpression.getExpression()
                .replaceAll("\\D", "")
                .split("");

        String[] operator = arithmeticExpression.getExpression()
                .replaceAll("\\d", "")
                .split("");

        Collections.addAll(stringQueue, operator);
        Collections.addAll(numberQueue, number);

        int sum = Integer.parseInt(numberQueue.poll());

        while (!stringQueue.isEmpty()) {
            int num = Integer.parseInt(numberQueue.poll());
            String poll = stringQueue.poll();
            System.out.println("num = " + num);
            System.out.println("poll = " + poll);

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
//        Arrays.stream(expressions).

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
