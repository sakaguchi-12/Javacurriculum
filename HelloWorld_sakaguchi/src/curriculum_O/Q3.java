package curriculum_O;

public class Q3 {
    public static void main(String[] args) {
        Employee3 emp = new Employee3();
        emp.setEmployeeId("E002");
        emp.setName("田中花子");

        System.out.println("社員ID: " + emp.getEmployeeId() + ", 名前: " + emp.getName());
    }
}

class Employee3 {
    private String employeeId;
    private String name;

    public void setEmployeeId(String id) { this.employeeId = id; }
    public void setName(String name) { this.name = name; }
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
}
