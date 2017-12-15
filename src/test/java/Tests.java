package test.java;

import liquibase.exception.LiquibaseException;
import main.java.hibernateMethods.ChatDB;
import main.java.run.Main;
import main.java.run.MyConnection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import main.java.items.*;

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
    public static void beforeClass()throws SQLException, ClassNotFoundException {
        MyConnection.connect();
        Statement stmt = MyConnection.connection.createStatement();
        String sql = "DROP TABLE IF EXISTS public.databasechangelog; DROP TABLE IF EXISTS user_copy;";
        stmt.execute(sql);
    }
    @AfterClass
    public static void afterClass()throws SQLException{
        MyConnection.disconnect();
    }

    @Test
    public void firstTest() throws SQLException, LiquibaseException, ClassNotFoundException{
        Main.updateChangelog("1.0");
        Chat chat = new Chat(1,"Chat1");
        ChatDB.addChat(chat);
        assertEquals(true,ChatDB.listChats().get(0).equals(chat));
    }
}
