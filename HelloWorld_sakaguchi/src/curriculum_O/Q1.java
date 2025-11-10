package curriculum_O;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("名前を入力してください: ");
        String name = sc.nextLine();

        Employee emp = new Employee();
        emp.name = name;
        emp.work();

        sc.close();
    }
}

// 社員クラス
class Employee {
    String name;

    public void work() {
        System.out.println(name + "は働いています。");
    }
}
