package dao;

import models.Departments;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentsDao implements DepartmentsDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Departments department) {
        try(Connection con=sql2o.open()) {
            String sql="INSERT INTO departments (name) VALUES (:name)";
            int id=(int) con.createQuery(sql,true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);

        }catch (Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public void addUserToDepartment(Users user, Departments department) {

    }

    @Override
    public List<Departments> getAll() {
        return null;
    }

    @Override
    public Departments findById(int id) {
        return null;
    }

    @Override
    public List<Users> getAllUsersInDepartment(int id) {
        return null;
    }

    @Override
    public void clearAll() {
        try (Connection con=sql2o.open()){
            String sql="DELETE FROM departments";
            con.createQuery(sql).executeUpdate();

        }
    }
}