import com.google.gson.Gson;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUsersDao;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;



import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        Sql2oNewsDao sql2oNewsDao;
        Sql2oUsersDao sql2oUsersDao;
        Sql2oDepartmentsDao sql2oDepartmentsDao;
        Connection conn;
        Gson gson = new Gson();
        staticFileLocation("/public");

        String connectionString = "jdbc:postgresql://localhost:5432/organisational_news_portal";
        //change the following line of code to your credentials
        Sql2o sql2o = new Sql2o(connectionString, "wangui", "33234159");
        sql2oDepartmentsDao=new Sql2oDepartmentsDao(sql2o);
        sql2oNewsDao=new Sql2oNewsDao(sql2o);
        sql2oUsersDao=new Sql2oUsersDao(sql2o);
        conn=sql2o.open();

        //create user,news,department
        post("/users/new", "application/json", (req, res) -> {
            Users user=gson.fromJson(res.body(),Users.class);
            sql2oUsersDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });

        after((req, res) ->{
            res.type("application/json");
        });

    }
}
