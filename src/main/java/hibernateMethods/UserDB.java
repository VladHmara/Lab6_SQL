package main.java.hibernateMethods;

import main.java.run.MyConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import main.java.items.*;
import java.util.List;

public class UserDB {

    public static void addUser(int id, String firstName, String lastName) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User user = new User(id, firstName, lastName);
        session.save(user);
        transaction.commit();
        session.close();
    }

    public static void updateUser(int id, String firstName, String lastName) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        user.setFirstName(firstName);
        user.setLastdName(lastName);
        session.update(user);
        transaction.commit();
        session.close();
    }

    public static void removeUser(int id) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public static List<User> listUsers() {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<User> users = session.createSQLQuery("SELECT * FROM \"user\"").list();

        transaction.commit();
        session.close();
        return users;
    }
}
