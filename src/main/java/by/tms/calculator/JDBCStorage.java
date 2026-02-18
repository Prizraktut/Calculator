package by.tms.calculator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCStorage {
    public void saveHistory(History history) {
        Connection connection = Connections.getConnection();
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement("insert into history(num1, num2, rez, date, operation) values (?, ?, ?, ?, ?)");
        preparedStatement.setDouble(1, history.getNum1());
        preparedStatement.setDouble(2, history.getNum2());
        preparedStatement.setDouble(3,history.getResult());
        preparedStatement.setString(4, history.getDate());
        preparedStatement.setString(5, history.getOperation());
        preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<History> getHistory() {
        Connection connection = Connections.getConnection();
        List<History> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from history ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double num1 = resultSet.getDouble("num1");
                double num2 = resultSet.getDouble("num2");
                double result = resultSet.getDouble("rez");
                String date = resultSet.getString("date");
                String operation = resultSet.getString("operation");
                History history = new History();
                history.setNum1(num1);
                history.setNum2(num2);
                history.setResult(result);
                history.setDate(date);
                history.setOperation(operation);
                list.add(history);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list ;
    }
}

