package hibernateMethods;


import run.MyConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import items.*;
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
    public static void addUser(User user) { addUser(user.getId(),user.getFirstName(),user.getLastName());}

    public static void updateUser(int id, String firstName, String lastName) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
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

    public static List listUsers() {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List users = session.createQuery("FROM items.User").list();

        transaction.commit();
        session.close();
        return users;
    }
}
