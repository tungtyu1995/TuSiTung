package bo;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Degree;
import model.Department;
import model.Employee;
import model.Position;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List<Employee> findAllEmployee() {
        return this.employeeDAO.findAllEmployee();
    }

    @Override
    public void add(Employee emloyee) {
        this.employeeDAO.add(emloyee);
    }

    @Override
    public List<Position> findAllPosition() {
        return this.employeeDAO.findAllPosition();
    }

    @Override
    public List<Degree> findAllDegree() {
        return this.employeeDAO.findAllDegree();
    }

    @Override
    public List<Department> findAllDepartment() {
        return this.employeeDAO.findAllDepartment();
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return this.employeeDAO.selectEmployeeById(id);
    }

    @Override
    public void edit(Employee emloyee) {
        this.employeeDAO.edit(emloyee);
    }

    @Override
    public void delete(int id) {
        this.employeeDAO.delete(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeDAO.findByName(name);
    }
}
