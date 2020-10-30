package dao;

import model.Degree;
import model.Department;
import model.Employee;
import model.Position;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployee();

    public void add(Employee emloyee);

    List<Position> findAllPosition();

    List<Degree> findAllDegree();

    List<Department> findAllDepartment();

    Employee selectEmployeeById(int id);

    void edit(Employee emloyee);

    void delete(int id);

    List<Employee> findByName(String name);
}
