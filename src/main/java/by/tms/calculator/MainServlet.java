package by.tms.calculator;

import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/calc")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("result",null);

        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String oper = req.getParameter("operations");


        if (num1.isEmpty() || num2.isEmpty() || oper.isEmpty()) {
            throw new RuntimeException("Invalid Input");
        }
        double num1Double = Double.parseDouble(num1);
        double num2Double = Double.parseDouble(num2);

        Calculate calculate = new Calculate(num1Double,num2Double,oper);
        double result = calculate.calculate();
        req.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
        History history = new History();
        history.setNum1(num1Double);
        history.setNum2(num2Double);
        history.setOperation(oper);
        history.setResult(result);
        history.setDate(Date.valueOf(LocalDate.now()));
        JDBCStorage  jdbcStorage = new JDBCStorage();
        jdbcStorage.saveHistory(history);

    }
}