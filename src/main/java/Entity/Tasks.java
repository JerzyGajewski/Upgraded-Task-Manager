package Entity;

public class Tasks {
    private String description;
    private String isImportant;

    public Tasks(){

    }
    public Tasks(String description, String isImportant) {
        this.description = description;
        this.isImportant = isImportant;
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
