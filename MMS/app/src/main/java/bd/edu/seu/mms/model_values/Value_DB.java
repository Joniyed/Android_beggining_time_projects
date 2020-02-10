package bd.edu.seu.mms.model_values;

public class Value_DB {
    private int id;
    private  String name;
    private  String phone;

    public Value_DB(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Value_DB(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Value_DB() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
