package curriculum_O;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("社員IDを入力してください: ");
        String id = sc.nextLine();
        System.out.print("名前を入力してください: ");
        String name = sc.nextLine();

        Employee2 emp = new Employee2();
        emp.employeeId = id;
        emp.name = name;
        emp.showInfo();

        sc.close();
    }
}

class Employee2 {
    String employeeId;
    String name;

    public void showInfo() {
        System.out.println("社員ID: " + employeeId + ", 名前: " + name);
    }
}
