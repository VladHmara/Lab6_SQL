package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyConnection {

    public static Connection connection;
    public static SessionFactory sessionFactory;

    static private String userName = "postgres";
    static private String password = "password";
    static private String url = "jdbc:postgresql://176.36.98.229:5432/postgres";

    public static void connect() throws SQLException, ClassNotFoundException{
        //BufferedReader br = new BufferedReader (new FileReader("D:\\Education2017\\СУБД\\lab3\\src\\DB_LoginPassword.txt"));
        //String ConnectionData = br.readLine();
        //userName = ConnectionData.split(" ")[0];
        //password = ConnectionData.split(" ")[1];
        //url = ConnectionData.split(" ")[2];

        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, userName, password);
        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("DB connected");
    }

    public static void disconnect()  throws SQLException{
        connection.close();
        System.out.println(" DB is disconected ");
    }
}
