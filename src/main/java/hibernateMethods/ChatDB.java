package main.java.hibernateMethods;

import main.java.run.MyConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import main.java.items.*;
import java.util.List;

public class ChatDB {

    public static void addChat(int id, String name) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Chat chat = new Chat(id, name);
        session.save(chat);
        transaction.commit();
        session.close();
    }

    public static void addChat(Chat chat) {
        addChat(chat.getId(),chat.getName());
    }

    public static void updateChat(int id, String name) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Chat chat = (Chat) session.get(Chat.class, id);
        chat.setName(name);
        session.update(chat);
        transaction.commit();
        session.close();
    }

    public static void removeChat(int id) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Chat chat = (Chat) session.get(Chat.class, id);
        session.delete(chat);
        transaction.commit();
        session.close();
    }

    public static List<Chat> listChats() {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Chat> chats = session.createSQLQuery("SELECT * FROM chat").list();

        transaction.commit();
        session.close();
        return chats;
    }
}
