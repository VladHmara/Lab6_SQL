import hibernateMethods.*;
import liquibase.exception.LiquibaseException;
import run.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import items.*;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
    @BeforeClass
    public static void beforeClass()throws SQLException, ClassNotFoundException, LiquibaseException {
        MyConnection.connect();
        Statement stmt = MyConnection.connection.createStatement();
        String sql = "DROP TABLE IF EXISTS public.databasechangelog; DROP TABLE IF EXISTS user_copy;";
        stmt.execute(sql);
        Main.updateChangelog("1.0","2.0");
    }
    @AfterClass
    public static void afterClass()throws SQLException, LiquibaseException{
        Main.updateChangelog("4.0");
        MyConnection.disconnect();
    }

    @Test
    public void v1RemoveDataTest() throws SQLException, LiquibaseException, ClassNotFoundException{
        ChatDB.removeChat(5);
        ChatUserDB.removeChatUser(6);
        MessageDB.removeMessage(6);
        UserHashDB.removeUserHash("asdsdfs3aew");
        UserDB.removeUser(4);

        assertEquals(4,ChatDB.listChats().size());
        assertEquals(5,ChatUserDB.listChatUsers().size());
        assertEquals(5,MessageDB.listMessages().size());
        assertEquals(3,UserHashDB.listUserHashs().size());
        assertEquals(3,UserDB.listUsers().size());
    }

    @Test
    public void v2AddDataTest() throws SQLException, LiquibaseException, ClassNotFoundException{
        Chat c = new Chat(5,"Chat5");
        ChatDB.addChat(c);
        User u = new User(4,"Oleg","Svorkin");
        UserDB.addUser(u);
        ChatUser cu = new ChatUser(6,4,1);
        ChatUserDB.addChatUser(cu);
        Message m = new Message(6,2,1,"Bye");
        MessageDB.addMessage(m);
        UserHash uh = new UserHash("asdsdfs3aew",4);
        UserHashDB.addUserHash(uh);


        assertEquals(c,ChatDB.listChats().get(4));
        assertEquals(cu,ChatUserDB.listChatUsers().get(5));
        assertEquals(m,MessageDB.listMessages().get(5));
        assertEquals(uh,UserHashDB.listUserHashs().get(3));
        assertEquals(u,UserDB.listUsers().get(3));
    }
    @Test
    public void v3UpdateDataTest() throws SQLException, LiquibaseException, ClassNotFoundException{
        ChatDB.updateChat(5,"Chat1");
        UserDB.updateUser(4,"Ol","Svorkin");
        ChatUserDB.updateChatUser(6,3,1);
        MessageDB.updateMessage(6,"bye");


        assertEquals("Chat1",((Chat)ChatDB.listChats().get(4)).getName());
        assertEquals("Ol",((User)UserDB.listUsers().get(3)).getFirstName());
        assertEquals(3,((ChatUser)ChatUserDB.listChatUsers().get(5)).getChatId());
        assertEquals("bye",((Message)MessageDB.listMessages().get(5)).getContent());
    }


}
