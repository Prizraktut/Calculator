package by.tms.calculator;

public class Calculate {
    private double num1;
    private double num2;
    private String operator;

    public Calculate(double num1, double num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public double calculate() {
        return switch (operator) {
            case "plus" -> num1 + num2;
            case "minus" -> num1 - num2;
            case "multi" -> num1 * num2;
            case "div" -> num1 / num2;
            default -> 0;
        };
    }


}
