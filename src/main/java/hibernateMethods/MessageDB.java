package main.java.hibernateMethods;

import main.java.run.MyConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import main.java.items.*;
import java.util.List;

public class MessageDB {

    public static void addMessage(int id, int fromUserId, int toChatId, String content) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Message message = new Message(id, fromUserId, toChatId, content);
        session.save(message);
        transaction.commit();
        session.close();
    }

    public static void updateMessage(int id, String content) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Message message = (Message) session.get(Message.class, id);
        message.setContent(content);
        session.update(message);
        transaction.commit();
        session.close();
    }

    public static void removeMessage(int id) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Message message = (Message) session.get(Message.class, id);
        session.delete(message);
        transaction.commit();
        session.close();
    }

    public static List<Message> listMessages() {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Message> messages = session.createSQLQuery("SELECT * FROM message").list();

        transaction.commit();
        session.close();
        return messages;
    }
}
