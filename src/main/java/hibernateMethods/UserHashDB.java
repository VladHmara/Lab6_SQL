package hibernateMethods;


import run.MyConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import items.*;
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
    public static void addUserHash(UserHash userHash) {addUserHash(userHash.getHash(),userHash.getUserId());}

    public static void updateUserHash(String hash, int userId) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        UserHash userHash = (UserHash) session.get(UserHash.class, hash);
        userHash.setUserId(userId);
        session.update(userHash);
        transaction.commit();
        session.close();
    }

    public static void removeUserHash(String hash) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        UserHash userHash = (UserHash) session.get(UserHash.class, hash);
        session.delete(userHash);
        transaction.commit();
        session.close();
    }

    public static List listUserHashs() {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List userHashs = session.createQuery("FROM items.UserHash").list();

        transaction.commit();
        session.close();
        return userHashs;
    }
}
