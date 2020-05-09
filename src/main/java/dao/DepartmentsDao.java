package dao;

import models.Departments;
import models.Users;

import java.util.List;

public interface DepartmentsDao {

    //create
    void add();
    void addUserToDepartment(Users user, Departments department);
    //read

    List<Departments> getAll();
    Departments findById(int id);
    List<Users> getAllUsersInDepartment(int id);
    //update
    //delete

}
