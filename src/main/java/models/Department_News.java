package models;

public class Department_News extends News {

    private String type;
    private int department_id;
    private final String TYPE_OF_NEWS="department";

    public Department_News(String title, String description, int department_id) {
        super(title, description);
        this.department_id = department_id;
        this.type=TYPE_OF_NEWS;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getDepartment_id() {
        return department_id;
    }
}
