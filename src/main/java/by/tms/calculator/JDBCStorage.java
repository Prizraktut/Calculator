package by.tms.calculator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCStorage {
    public void saveHistory(History history) {
        Connection connection = Connections.getConnection();
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement("insert into history( num1, num2,rez,date,operation) values (?, ?, ?, ?, ?)");
        preparedStatement.setDouble(1, history.getNum1());
        preparedStatement.setDouble(2, history.getNum2());
        preparedStatement.setDouble(3,history.getResult());
        preparedStatement.setDate(5, (Date) history.getDate());
        preparedStatement.setString(4,history.getOperation());
        preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

