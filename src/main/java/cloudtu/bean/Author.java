package cloudtu.bean;

public class Author {
    private String name;
    private String department;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String toString() {
        return String.format("{name : '%s', department : '%s'}", name, department);
    }
}
