import java.util.ArrayList;
import java.util.List;

public class Department {
    public String name;
    public Employee manager; 
    public List<Employee> employees = new ArrayList<>(); 

    public Department(String name) {
        this.name = name;
    }
}
