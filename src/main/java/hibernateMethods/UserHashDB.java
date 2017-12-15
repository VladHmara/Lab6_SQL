package main.java.hibernateMethods;

import main.java.run.MyConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import main.java.items.*;
import java.util.List;

public class UserHashDB {

    public static void addUserHash(String hash, int userId) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        UserHash userHash = new UserHash(hash,userId);
        session.save(userHash);
        transaction.commit();
        session.close();
    }

    public static void updateUserHash(String hash, int userId) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        UserHash userHash = (UserHash) session.get(UserHash.class, userId);
        userHash.setHash(hash);
        session.update(userHash);
        transaction.commit();
        session.close();
    }

    public static void removeUserHash(int userId) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        UserHash userHash = (UserHash) session.get(UserHash.class, userId);
        session.delete(userHash);
        transaction.commit();
        session.close();
    }

    public static List<UserHash> listUserHashs() {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<UserHash> userHashs = session.createSQLQuery("SELECT * FROM userHash").list();

        transaction.commit();
        session.close();
        return userHashs;
    }
}
