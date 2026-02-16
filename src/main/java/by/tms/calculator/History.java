package by.tms.calculator;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class History {
private double num1;
private double num2;
private String operation;
private double result;
private Date date;

}
