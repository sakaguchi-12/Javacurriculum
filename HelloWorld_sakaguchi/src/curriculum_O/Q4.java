package curriculum_O;

public class Q4 {
    public static void main(String[] args) {
        FullTimeEmployee full = new FullTimeEmployee("E003", "佐藤太郎");
        PartTimeEmployee part = new PartTimeEmployee("E004", "鈴木花子");

        System.out.println("正社員の給与: " + full.calculateDailyWage(9) + " 円");
        System.out.println("パート社員の給与: " + part.calculateDailyWage(9) + " 円");
    }
}

abstract class Employee4 {
    protected String id;
    protected String name;

    public Employee4(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract int calculateDailyWage(int hoursWorked);
}

class FullTimeEmployee extends Employee4 {
    private static final int HOURLY_RATE = 1200;

    public FullTimeEmployee(String id, String name) {
        super(id, name);
    }

    @Override
    public int calculateDailyWage(int hoursWorked) {
        int overtime = Math.max(0, hoursWorked - 8);
        int regular = hoursWorked - overtime;
        return (regular * HOURLY_RATE) + (int)(overtime * HOURLY_RATE * 1.25);
    }
}

class PartTimeEmployee extends Employee4 {
    private static final int HOURLY_RATE = 1000;

    public PartTimeEmployee(String id, String name) {
        super(id, name);
    }

    @Override
    public int calculateDailyWage(int hoursWorked) {
        return hoursWorked * HOURLY_RATE;
    }
}
