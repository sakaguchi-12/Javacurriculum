package curriculum_O;

import java.util.ArrayList;
import java.util.List;

public class Q6 {
    public static void main(String[] args) {
        List<Billable> list = new ArrayList<>();
        list.add(new FullTimeEmployee6("I001", "小林太郎"));
        list.add(new ContractEmployee6("I002", "長谷川花子"));

        for (Billable b : list) {
            System.out.println(((Employee6)b).getName() + " の日給は " + b.costForDay(9) + " 円");
        }
    }
}

interface Billable {
    int costForDay(int hoursWorked);
}

abstract class Employee6 implements Billable {
    protected String id;
    protected String name;

    public Employee6(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
}

class FullTimeEmployee6 extends Employee6 {
    public FullTimeEmployee6(String id, String name) { super(id, name); }

    public int costForDay(int hoursWorked) {
        int rate = 1250;
        int overtime = Math.max(0, hoursWorked - 8);
        int regular = hoursWorked - overtime;
        return (regular * rate) + (int)(overtime * rate * 1.25);
    }
}

class ContractEmployee6 extends Employee6 {
    public ContractEmployee6(String id, String name) { super(id, name); }

    public int costForDay(int hoursWorked) {
        return hoursWorked * 1000;
    }
}
