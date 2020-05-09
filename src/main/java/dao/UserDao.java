package dao;

public interface UserDao {

    //create

    void addUser(String name,String position,String role);
    void addUserToDepartment(int id,int department_id);

    //read

    //update

    //delete
}
