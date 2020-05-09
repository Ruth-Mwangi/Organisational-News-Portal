package dao;

import models.Departments;
import models.Users;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oDepartmentsDaoTest {
    private static Sql2oDepartmentsDao sql2oDepartmentsDao;
    private static Sql2oUsersDao sql2oUsersDao;
    private static Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_news_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "wangui", "33234159");
        sql2oDepartmentsDao=new Sql2oDepartmentsDao(sql2o);
        sql2oUsersDao=new Sql2oUsersDao(sql2o);
        System.out.println("connected to database");
        conn=sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
        sql2oDepartmentsDao.clearAll();
        sql2oUsersDao.clearAll();
        System.out.println("clearing database");
    }
    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void idSetForAddedDepartment() {
        Departments department=setUpNewDepartment();
        int originalId=department.getId();
        sql2oDepartmentsDao.add(department);
        assertNotEquals(originalId,department.getId());
    }



    @Test
    public void addUserToDepartment() {
        Departments department=setUpNewDepartment();
        sql2oDepartmentsDao.add(department);
        Users user=setUpNewUser();
        Users otherUser= new Users("Wangui","intern","Paper work");
        sql2oUsersDao.add(user);
        sql2oUsersDao.add(otherUser);
        sql2oDepartmentsDao.addUserToDepartment(user,department);
        sql2oDepartmentsDao.addUserToDepartment(otherUser,department);
        assertEquals(2,sql2oDepartmentsDao.getAllUsersInDepartment(department.getId()).size());
        assertEquals(2,sql2oDepartmentsDao.findById(department.getId()).getSize());
    }

    @Test
    public void getAll() {
        Departments department=setUpNewDepartment();
        Departments otherDepartment=new Departments("printing","printing of books");
        sql2oDepartmentsDao.add(department);
        sql2oDepartmentsDao.add(otherDepartment);
        assertEquals(department,sql2oDepartmentsDao.getAll().get(0));
        assertEquals(otherDepartment,sql2oDepartmentsDao.getAll().get(1));
    }

    @Test
    public void correctDepartmentIsReturnedFindById() {
        Departments department=setUpNewDepartment();
        Departments otherDepartment=new Departments("printing","printing of books");
        sql2oDepartmentsDao.add(department);
        sql2oDepartmentsDao.add(otherDepartment);
        assertEquals(department,sql2oDepartmentsDao.findById(department.getId()));
        assertEquals(otherDepartment,sql2oDepartmentsDao.findById(otherDepartment.getId()));

    }

    @Test
    public void getAllUsersInDepartment() {
        Departments department=setUpNewDepartment();
        sql2oDepartmentsDao.add(department);
        Users user=setUpNewUser();
        Users otherUser= new Users("Wangui","intern","Paper work");
        sql2oUsersDao.add(user);
        sql2oUsersDao.add(otherUser);
        sql2oDepartmentsDao.addUserToDepartment(user,department);
        sql2oDepartmentsDao.addUserToDepartment(otherUser,department);
        assertEquals(2,sql2oDepartmentsDao.getAllUsersInDepartment(department.getId()).size());
        assertEquals(2,sql2oDepartmentsDao.findById(department.getId()).getSize());
    }

    //helper
    private Departments setUpNewDepartment() {
        return new Departments("Editing","editing of newspaper");
    }
    private Users setUpNewUser() {
        return new Users("Ruth Mwangi","manager","Editor");
    }
}