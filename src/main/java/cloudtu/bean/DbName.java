package cloudtu.bean;

public class DbName {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {        
        return name;
    }
}
