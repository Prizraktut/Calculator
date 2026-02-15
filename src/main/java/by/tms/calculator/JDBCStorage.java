package by.tms.calculator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCStorage {

    public  void save(Usera usera){
        try {
           Connection connection = Connections.getConnection();
            PreparedStatement preparedStatement  = connection.prepareStatement("insert into users(id, name, surname) values (?, ?, ?)");
            preparedStatement.setInt(1, usera.getId());
            preparedStatement.setString(2, usera.getName());
            preparedStatement.setString(3, usera.getSurname());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateName(Integer uniq, String name){
        Connection connection = Connections.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update users set name = ? where uniq = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, uniq);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteByUniq(Integer uniq){
        Connection connection = Connections.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where uniq = ?");
            preparedStatement.setInt(1, uniq);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usera> findAll(){
        Connection connection = Connections.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Usera> usera = new ArrayList<>();

            while (resultSet.next()) {
                //int uniq = resultSet.getInt("uniq");
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surName = resultSet.getString("surname");
                Usera users = new Usera();
                users.setId(id);
                users.setName(name);
                users.setSurname(surName);
                usera.add(users);

            }
            connection.close();
            return usera;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

