package curriculum_O;

import java.util.ArrayList;
import java.util.List;

public class Q5 {
    public static void main(String[] args) {
        List<Employee5> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee5("F001", "山田太郎"));
        employees.add(new FullTimeEmployee5("F002", "佐藤次郎"));
        employees.add(new ContractEmployee5("C001", "鈴木花子"));
        employees.add(new ContractEmployee5("C002", "田中一郎"));

        for (Employee5 e : employees) {
            System.out.println(e.name + " の給与: " + e.calculateDailyWage(9) + " 円");
        }
    }
}

abstract class Employee5 {
    protected String id;
    protected String name;

    public Employee5(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract int calculateDailyWage(int hoursWorked);
}

class FullTimeEmployee5 extends Employee5 {
    public FullTimeEmployee5(String id, String name) { super(id, name); }

    public int calculateDailyWage(int hoursWorked) {
        int rate = 1250;
        int overtime = Math.max(0, hoursWorked - 8);
        int regular = hoursWorked - overtime;
        return (regular * rate) + (int)(overtime * rate * 1.25);
    }
}

class ContractEmployee5 extends Employee5 {
    public ContractEmployee5(String id, String name) { super(id, name); }

    public int calculateDailyWage(int hoursWorked) {
        return hoursWorked * 1000;
    }
}
