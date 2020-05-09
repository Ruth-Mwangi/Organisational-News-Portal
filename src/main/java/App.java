import com.google.gson.Gson;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();
        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "wangui", "33234159");

    }
}
