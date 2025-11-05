package curriculum_B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Object {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ① 基本概念
        System.out.println("【① 基本概念】");
        System.out.print("名前を入力してください: ");
        String inputName = sc.nextLine();

        Employee1 emp1 = new Employee1();
        emp1.name = inputName;
        emp1.work();
        System.out.println();

        // ② クラスとオブジェクト
        System.out.println("【② クラスとオブジェクト】");
        System.out.print("社員IDを入力してください: ");
        String id2 = sc.nextLine();
        System.out.print("名前を入力してください: ");
        String name2 = sc.nextLine();

        Employee2 emp2 = new Employee2();
        emp2.employeeId = id2;
        emp2.name = name2;
        emp2.showInfo();
        System.out.println();

        // ③ カプセル化
        System.out.println("【③ カプセル化】");
        Employee3 emp3 = new Employee3();
        emp3.setEmployeeId("E002");
        emp3.setName("田中花子");
        System.out.println("社員ID: " + emp3.getEmployeeId() + ", 名前: " + emp3.getName());
        System.out.println();

        // ④ 継承
        System.out.println("【④ 継承】");
        FullTimeEmployee4 full = new FullTimeEmployee4("E003", "佐藤太郎");
        PartTimeEmployee4 part = new PartTimeEmployee4("E004", "鈴木花子");
        System.out.println("正社員の給与: " + full.calculateDailyWage(9) + " 円");
        System.out.println("パート社員の給与: " + part.calculateDailyWage(9) + " 円");
        System.out.println();

        // ⑤ ポリモーフィズム
        System.out.println("【⑤ ポリモーフィズム】");
        List<Employee5> employees5 = new ArrayList<>();
        employees5.add(new FullTimeEmployee5("F001", "山田太郎"));
        employees5.add(new FullTimeEmployee5("F002", "佐藤次郎"));
        employees5.add(new ContractEmployee5("C001", "鈴木三郎"));
        employees5.add(new ContractEmployee5("C002", "田中花子"));

        for (Employee5 e : employees5) {
            System.out.println("社員ID: " + e.id + ", 名前: " + e.name + ", 給与: " + e.calculateDailyWage(9) + " 円");
        }
        System.out.println();

        // ⑥ インターフェイスと抽象クラス
        System.out.println("【⑥ インターフェイスと抽象クラス】");
        List<Billable> employees6 = new ArrayList<>();
        employees6.add(new FullTimeEmployee6("I001", "小林太郎"));
        employees6.add(new ContractEmployee6("I002", "長谷川花子"));

        for (Billable b : employees6) {
            System.out.println(((Employee6)b).getName() + " の日給は " + b.costForDay(9) + " 円");
        }
        System.out.println();

        // ⑦ SOLID設計原則
        System.out.println("【⑦ SOLID原則】");
        List<Employee7> staff = new ArrayList<>();
        staff.add(new FullTimeEmployee7("高橋一郎", 8));
        staff.add(new ContractEmployee7("中村花子", 9));

        SalaryReport report = new SalaryReport(new SalaryCalculator7());
        report.generateReport(staff);

        sc.close();
    }
}

// ① 基本概念
class Employee1 {
    String name;
    public void work() {
        System.out.println(name + "は働いています。");
    }
}

// ② クラスとオブジェクト
class Employee2 {
    String employeeId;
    String name;
    public void showInfo() {
        System.out.println("社員ID: " + employeeId + ", 名前: " + name);
    }
}

// ③ カプセル化
class Employee3 {
    private String employeeId;
    private String name;
    public void setEmployeeId(String id) { this.employeeId = id; }
    public void setName(String name) { this.name = name; }
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
}

// ④ 継承
abstract class Employee4 {
    private String employeeId;
    private String name;
    public Employee4(String id, String name) {
        this.employeeId = id;
        this.name = name;
    }
    public abstract int calculateDailyWage(int hoursWorked);
}
class FullTimeEmployee4 extends Employee4 {
    private static final int HOURLY_RATE = 1200;
    public FullTimeEmployee4(String id, String name) { super(id, name); }
    public int calculateDailyWage(int hoursWorked) {
        int overtime = Math.max(0, hoursWorked - 8);
        int regular = hoursWorked - overtime;
        return (regular * HOURLY_RATE) + (int)(overtime * HOURLY_RATE * 1.25);
    }
}
class PartTimeEmployee4 extends Employee4 {
    private static final int HOURLY_RATE = 1000;
    public PartTimeEmployee4(String id, String name) { super(id, name); }
    public int calculateDailyWage(int hoursWorked) {
        return hoursWorked * HOURLY_RATE;
    }
}

// ⑤ ポリモーフィズム
abstract class Employee5 {
    protected String id;
    protected String name;
    public Employee5(String id, String name) { this.id = id; this.name = name; }
    public abstract int calculateDailyWage(int hoursWorked);
}
class FullTimeEmployee5 extends Employee5 {
    public FullTimeEmployee5(String id, String name) { super(id, name); }
    public int calculateDailyWage(int hoursWorked) {
        int hourlyRate = 1250;
        int overtime = Math.max(0, hoursWorked - 8);
        int regular = hoursWorked - overtime;
        return (regular * hourlyRate) + (int)(overtime * hourlyRate * 1.25);
    }
}
class ContractEmployee5 extends Employee5 {
    public ContractEmployee5(String id, String name) { super(id, name); }
    public int calculateDailyWage(int hoursWorked) {
        return hoursWorked * 1000;
    }
}

// ⑥ インターフェイスと抽象クラス
interface Billable {
    int costForDay(int hoursWorked);
}
abstract class Employee6 implements Billable {
    protected String id;
    protected String name;
    public Employee6(String id, String name) { this.id = id; this.name = name; }
    public String getName() { return name; }
}
class FullTimeEmployee6 extends Employee6 {
    public FullTimeEmployee6(String id, String name) { super(id, name); }
    public int costForDay(int hoursWorked) {
        int hourlyRate = 1250;
        int overtime = Math.max(0, hoursWorked - 8);
        int regular = hoursWorked - overtime;
        return (regular * hourlyRate) + (int)(overtime * hourlyRate * 1.25);
    }
}
class ContractEmployee6 extends Employee6 {
    public ContractEmployee6(String id, String name) { super(id, name); }
    public int costForDay(int hoursWorked) { return hoursWorked * 1000; }
}

// ⑦ SOLID設計原則
interface Payable {
    int calculateSalary();
    String getName();
}
abstract class Employee7 implements Payable {
    protected String name;
    protected int hours;
    public Employee7(String name, int hours) { this.name = name; this.hours = hours; }
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
    public int calculateSalary() { return hours * 1000; }
}
class SalaryCalculator7 {
    public int calculate(Payable emp) { return emp.calculateSalary(); }
}
class SalaryReport {
    private final SalaryCalculator7 calculator;
    public SalaryReport(SalaryCalculator7 calculator) { this.calculator = calculator; }
    public void generateReport(List<Employee7> employees) {
        for (Employee7 e : employees) {
            System.out.println(e.getName() + " の給料は " + calculator.calculate(e) + " 円です。");
        }
    }
}
