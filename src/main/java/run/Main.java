package run;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import hibernateMethods.*;

import java.io.File;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, LiquibaseException{
        MyConnection.connect();
        updateChangelog("1.0","2.0");
        ChatDB.addChat(6,"Chat6");
        MyConnection.disconnect();
    }

    public static void updateChangelog(String versionOfChangelog) throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(MyConnection.connection));
        for (File f:new File("src/main/resources/liquibase").listFiles()) {
            if(f.getName().contains(versionOfChangelog))
            {
                Liquibase liq = new Liquibase(f.getPath(), new FileSystemResourceAccessor(), database);
                liq.update(new Contexts(), new LabelExpression());
                break;
            }
        }
    }

    public static void updateChangelog(String ... versionOfChangelog) throws LiquibaseException {
        for (String version : versionOfChangelog)
            updateChangelog(version);
    }
}
