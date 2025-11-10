package curriculum_C;

import java.util.Random;
import java.util.Scanner;

public class Question6_1 {

    public static void main(String[] args) { // ← args に修正！
        Scanner sc = new Scanner(System.in);
        CPU cpu = new CPU();

        while (true) {
            System.out.print("グー(0), チョキ(1), パー(2) を入力: ");
            int player = sc.nextInt();

            String[] hands = {"グー", "チョキ", "パー"};
            if (player < 0 || player > 2) {
                System.out.println("0〜2の数字を入力してください！");
                continue;
            }

            System.out.println("あなたの手: " + hands[player]);

            int cpuHand = cpu.getHand();
            System.out.println("CPUの手: " + cpu.handToString(cpuHand));

            if (player == cpuHand) {
                System.out.println("あいこです！");
            } else if ((player == 0 && cpuHand == 1) ||
                       (player == 1 && cpuHand == 2) ||
                       (player == 2 && cpuHand == 0)) {
                System.out.println("あなたの勝ち！");
                break;
            } else {
                System.out.println("あなたの負け…");
            }
        }

        sc.close();
    }

    // ===== CPUクラス =====
    static class CPU {
        private Random rand = new Random();

        public int getHand() {
            return rand.nextInt(3); // 0〜2
        }

        public String handToString(int hand) {
            switch (hand) {
                case 0: return "グー";
                case 1: return "チョキ";
                case 2: return "パー";
                default: return "不明";
            }
        }
    }
}
