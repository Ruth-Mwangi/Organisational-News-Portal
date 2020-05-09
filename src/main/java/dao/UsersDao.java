package dao;

import models.Users;

import java.util.List;

public interface UsersDao {

    //create

    void  add(Users user);

    //read

    List<Users> getAll();
    //List<Departments> getAllUserDepartments();
    Users findById(int id);

    //update

    //delete
}
