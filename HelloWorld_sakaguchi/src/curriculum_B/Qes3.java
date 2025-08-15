package curriculum_B;

import java.util.Scanner;

public class Qes3 {

	public static void main(String[] args) {
	    // 1. for文で1～10表示
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        // 2. for文で2～20偶数表示
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
        }

        // 3. for文で10～1カウントダウン
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }

        // 4. for文で1～100合計
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("合計：" + sum);

        // 5. 三角形出力
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 6. while文で1～10表示
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        // 7. while文で2～20偶数表示
        int j = 2;
        while (j <= 20) {
            System.out.println(j);
            j += 2;
        }

        // 8. while文で10～1カウントダウン
        int k = 10;
        while (k >= 1) {
            System.out.println(k);
            k--;
        }

        // 9. while文で1～100合計
        int l = 1;
        int total = 0;
        while (l <= 100) {
            total += l;
            l++;
        }
        System.out.println("合計：" + total);

        // 10. ユーザーから数値入力
        Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print("数値を入力してください（0で終了）：");
            num = sc.nextInt();
            if (num == 0) {
                System.out.println("終了しました");
                break;
            }
        }

        sc.close();

	}

}
