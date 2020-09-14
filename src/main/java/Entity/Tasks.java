package Entity;

public class Tasks {
    private String description;
    private Boolean isImportant;

    public Tasks(){

    }
    public Tasks(String description, Boolean isImportant) {
        this.description = description;
        this.isImportant = isImportant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getImportant() {
        return isImportant;
    }

    public void setImportant(Boolean important) {
        isImportant = important;
    }
}
