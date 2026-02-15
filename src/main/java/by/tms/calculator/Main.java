package by.tms.calculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","admin");
//            Statement statement = connection.createStatement();
//            statement.execute("insert into users values (8,'Vitaly','Popov',default)");
//            connection.close();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        JDBCStorage jdbcStorage = new JDBCStorage();

  //     Usera usera = new Usera();
//        usera.setId(11);
//        usera.setSurname("Gorky");
//        usera.setName("Maksim");
        //jdbcStorage.updateName(5,"Olga");

        List<Usera> all = jdbcStorage.findAll();
        System.out.println(all);


    }
}
