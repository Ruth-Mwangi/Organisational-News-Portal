package models;

import java.util.Objects;

public class News {

    private int id;
    private String type;
    private int department_id;
    private String title;
    private String description;
    private final String TYPE_OF_NEWS="general";

    public News(String title, String description) {
        this.title = title;
        this.description = description;
        this.type=TYPE_OF_NEWS;
        this.department_id=0;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                department_id == news.department_id &&
                Objects.equals(type, news.type) &&
                Objects.equals(title, news.title) &&
                Objects.equals(description, news.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, department_id, title, description);
    }
}
