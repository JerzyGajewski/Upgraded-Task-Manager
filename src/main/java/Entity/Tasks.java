package Entity;

public class Tasks {
    private int id;
    private String description;
    private String isImportant;

    public Tasks(){

    }
    public Tasks(int id, String description, String isImportant) {
        this.id = id;
        this.description = description;
        this.isImportant = isImportant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImportant() {
        return isImportant;
    }

    public void setImportant(String  important) {
        isImportant = important;
    }
}
