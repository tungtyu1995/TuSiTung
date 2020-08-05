package case_study.models;

public class Employee {
    private int codeEmployee;
    private String nameEmployee;
    private int ageEmployee;
    private String addressEmployee;

    public Employee() {
    }

    public Employee(String nameEmployee, int ageEmployee, String addressEmployee) {
        this.nameEmployee = nameEmployee;
        this.ageEmployee = ageEmployee;
        this.addressEmployee = addressEmployee;
    }

    public int getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(int codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAgeEmployee() {
        return ageEmployee;
    }

    public void setAgeEmployee(int ageEmployee) {
        this.ageEmployee = ageEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s","",nameEmployee,ageEmployee,addressEmployee);
    }
    public String toStringWithIndex(){
        return String.format("%-20s%-30s%-20s%-20s",nameEmployee,ageEmployee,addressEmployee);
    }
}
