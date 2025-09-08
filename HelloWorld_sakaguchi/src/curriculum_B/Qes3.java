package curriculum_B;

import java.util.Random;
import java.util.Scanner;

public class Qes3 {
    public static void main(String[] args) {
        // for文で1～10表示
        for (int i = 1; i <= 10; i++) System.out.println(i);

        // for文で2～20偶数表示
        for (int i = 2; i <= 20; i += 2) System.out.println(i);

        // for文で10～1カウントダウン
        for (int i = 10; i >= 1; i--) System.out.println(i);

        // for文で1～100合計
        int sum = 0;
        for (int i = 1; i <= 100; i++) sum += i;
        System.out.println("合計：" + sum);

        // 三角形出力
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }

        // while文で1～10表示
        int i = 1;
        while (i <= 10) { System.out.println(i); i++; }

        // while文で2～20偶数表示
        int j = 2;
        while (j <= 20) { System.out.println(j); j += 2; }

        // while文で10～1カウントダウン
        int k = 10;
        while (k >= 1) { System.out.println(k); k--; }

        // while文で1～100合計
        int l = 1, total = 0;
        while (l <= 100) { total += l; l++; }
        System.out.println("合計：" + total);

        // --- ユーザーから数値入力（0で終了） ---
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("数値を入力してください（0で終了）：");
            String line = sc.nextLine().trim(); // 1行で受ける（←ここがポイント）
            if (line.isEmpty()) continue;
            int num;
            try {
                num = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("数字を入力してください（例：1、2、0で終了）");
                continue; // 無効入力は捨てて続行
            }
            if (num == 0) {
                System.out.println("終了しました");
                break;
            }
        }

        // 11. 図の通りの出力（九九）
        System.out.println("\n--- 11. 九九 ---");
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                System.out.printf("%02d * %02d = %02d || ", a, b, a * b);
            }
            System.out.println();
        }

        // 12. 商品の在庫数をランダムで表示
        System.out.println("\n--- 12. 在庫表示 ---");
        System.out.print("商品をカンマ/読点区切りで入力してください：");
        String input = sc.nextLine();
        String[] items = input.split("、|,\\s*"); // 「、」またはカンマ区切り

        Random rand = new Random();
        int tvCount = rand.nextInt(12);    // 0〜11
        int displayCount = 11 - tvCount;   // テレビと合計11台にする例

        for (String raw : items) {
            String item = raw.trim();
            switch (item) {
                case "パソコン":
                case "冷蔵庫":
                case "扇風機":
                case "洗濯機":
                case "加湿器":
                    int stock = rand.nextInt(12);
                    System.out.println(item + "の残り台数は" + stock + "台です");
                    break;
                case "テレビ":
                    System.out.println("テレビの残り台数は" + tvCount + "台です");
                    break;
                case "ディスプレイ":
                    System.out.println("ディスプレイの残り台数は" + displayCount + "台です");
                    break;
                default:
                    System.out.println("「" + item + "」は指定の商品ではありません");
            }
        }

        sc.close();
    }
}

