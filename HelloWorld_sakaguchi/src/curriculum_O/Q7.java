package curriculum_O;

import java.util.ArrayList;
import java.util.List;

public class Q7 {
    public static void main(String[] args) {
        List<Employee7> staff = new ArrayList<>();
        staff.add(new FullTimeEmployee7("高橋一郎", 8));
        staff.add(new ContractEmployee7("中村花子", 9));

        SalaryReport report = new SalaryReport(new SalaryCalculator7());
        report.generateReport(staff);
    }
}

interface Payable {
    int calculateSalary();
    String getName();
}

abstract class Employee7 implements Payable {
    protected String name;
    protected int hours;

    public Employee7(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public String getName() { return name; }
}

class FullTimeEmployee7 extends Employee7 {
    public FullTimeEmployee7(String name, int hours) { super(name, hours); }

    public int calculateSalary() {
        int rate = 1200;
        int overtime = Math.max(0, hours - 8);
        int regular = hours - overtime;
        return (regular * rate) + (int)(overtime * rate * 1.25);
    }
}

class ContractEmployee7 extends Employee7 {
    public ContractEmployee7(String name, int hours) { super(name, hours); }

    public int calculateSalary() {
        return hours * 1000;
    }
}

class SalaryCalculator7 {
    public int calculate(Payable emp) {
        return emp.calculateSalary();
    }
}

class SalaryReport {
    private final SalaryCalculator7 calculator;

    public SalaryReport(SalaryCalculator7 calculator) {
        this.calculator = calculator;
    }

    public void generateReport(List<Employee7> employees) {
        for (Employee7 e : employees) {
            int salary = calculator.calculate(e);
            System.out.println(e.getName() + " の給料は " + salary + " 円です。");
        }
    }
}
