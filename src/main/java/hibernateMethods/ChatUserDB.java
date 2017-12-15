package main.java.hibernateMethods;

import main.java.run.MyConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import main.java.items.*;
import java.util.List;

public class ChatUserDB {

    public static void addChatUser(int id, int chatId, int userId) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        ChatUser chatUser = new ChatUser(id, chatId, userId);
        session.save(chatUser);
        transaction.commit();
        session.close();
    }

    public static void updateChatUser(int id, int chatId, int userId) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        ChatUser chatUser = (ChatUser) session.get(ChatUser.class, id);
        chatUser.setChatId(chatId);
        chatUser.setUserId(userId);
        session.update(chatUser);
        transaction.commit();
        session.close();
    }

    public static void removeChatUser(int id) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        ChatUser chatUser = (ChatUser) session.get(ChatUser.class, id);
        session.delete(chatUser);
        transaction.commit();
        session.close();
    }

    public static List<ChatUser> listChatUsers() {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<ChatUser> chatUsers = session.createSQLQuery("SELECT * FROM chatUser").list();

        transaction.commit();
        session.close();
        return chatUsers;
    }
}
