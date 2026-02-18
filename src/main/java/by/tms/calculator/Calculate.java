package by.tms.calculator;

import java.sql.Date;
import java.time.LocalDate;

public class Calculate {
    private double num1;
    private double num2;
    private String operator;
    private double result;

    public Calculate(double num1, double num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public History processing(){
        calculate();
        return  createRecordHistory();
    }

    public void calculate() {
        switch (operator) {

            case "plus" -> result = num1 + num2;
            case "minus" -> result = num1 - num2;
            case "multi" -> result = num1 * num2;
            case "div" -> result = num1 / num2;
        }

    }
    public History createRecordHistory() {
        History history = new History();
        history.setNum1(num1);
        history.setResult(result);
        history.setNum2(num2);
        history.setOperation(operator);
        history.setDate(Date.valueOf(LocalDate.now()).toString());
        return history;
    }
}
