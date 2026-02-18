package by.tms.calculator;

import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/calc")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        JDBCStorage  jdbcStorage = new JDBCStorage();
        List<History> historyList = jdbcStorage.getHistory();
        req.setAttribute("histories",historyList);
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
        History history = calculate.processing();
        req.setAttribute("result", history.getResult());
        JDBCStorage  jdbcStorage = new JDBCStorage();
        jdbcStorage.saveHistory(history);
        List<History> historyList = jdbcStorage.getHistory();
        req.setAttribute("histories",historyList);
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}