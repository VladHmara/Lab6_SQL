package hibernateMethods;


import run.MyConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import items.*;
import java.util.List;

public class MessageDB {

    public static void addMessage(int id, int fromUserId, int toChatId, String content) {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        if(session.get(Chat.class,toChatId) == null);
            Chat chat = new Chat(toChatId,"NewChat");
        Message message = new Message(id, fromUserId, toChatId, content);
        session.save(message);
        transaction.commit();
        session.close();
    }
    public static void addMessage(Message message) {addMessage(message.getId(),message.getFromUserId(),message.getToChatId(),message.getContent());}

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

    public static List listMessages() {
        Session session = MyConnection.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List messages = session.createQuery("FROM items.Message").list();

        transaction.commit();
        session.close();
        return messages;
    }
}
