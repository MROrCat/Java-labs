import java.util.List;

public class Employee {
    public String name;
    public Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        
        this.department.employees.add(this); 
    }

    public List<Employee> getColleagues() {
        return department.employees; 
    }

    @Override
    public String toString() {
        if (department.manager == this) {
            return name + " начальник отдела " + department.name;
        } 
        else {
            String managerName = (department.manager != null) ? department.manager.name : "не назначен";
            return name + " работает в отделе " + department.name + ", начальник которого " + managerName;
        }
    }
}