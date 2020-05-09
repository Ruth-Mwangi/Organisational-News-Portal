package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oUsersDaoTest {

    private static Sql2oUsersDao sql2oUsersDao;
    private static Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_news_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "wangui", "33234159");
        sql2oUsersDao=new Sql2oUsersDao(sql2o);
        conn=sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        sql2oUsersDao.clearAll();
        System.out.println("clearing database");

    }

    @AfterClass
    public static void shutDown() throws Exception{ //changed to static
        conn.close();
        System.out.println("connection closed");
    }


}