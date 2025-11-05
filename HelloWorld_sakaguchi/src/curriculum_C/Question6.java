package curriculum_C;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Question6 {
    private static final Random RAND = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 🥊 Step1: じゃんけん対決
        playJanken(sc);

        // ⚔ Step2: バトル開始
        playBattle(sc);

        sc.close();
    }

    // ==============================
    // 🥊 じゃんけんパート
    // ==============================
    public static void playJanken(Scanner sc) {
        System.out.println("\n=== じゃんけん対決 ===");
        CPU cpu = new CPU();

        while (true) {
            System.out.print("グー(0), チョキ(1), パー(2) を入力: ");
            if (!sc.hasNextInt()) {
                System.out.println("数字を入力してください！（0/1/2）");
                sc.next();
                continue;
            }

            int player = sc.nextInt();
            if (player < 0 || player > 2) {
                System.out.println("0〜2の数字を入力してください！");
                continue;
            }

            String[] hands = {"グー", "チョキ", "パー"};
            System.out.println("あなたの手: " + hands[player]);
            int cpuHand = cpu.getHand();
            System.out.println("CPUの手: " + cpu.handToString(cpuHand));

            if (player == cpuHand) {
                System.out.println("あいこです！");
            } else if ((player == 0 && cpuHand == 1) ||
                       (player == 1 && cpuHand == 2) ||
                       (player == 2 && cpuHand == 0)) {
                System.out.println("あなたの勝ち！");
                System.out.println("=== バトル開始！ ===");
                break;
            } else {
                System.out.println("あなたの負け…再挑戦！");
            }
        }
    }

    // ==============================
    // ⚔ バトルパート
    // ==============================
    public static void playBattle(Scanner sc) {
        StringBuilder log = new StringBuilder();
        log.append("=== Player vs Daemon === ").append(LocalDateTime.now()).append("\n");

        try {
            sc.nextLine(); // 改行のバッファ消去
            System.out.print("プレイヤー名を入力してください: ");
            String playerName = sc.nextLine().trim();
            if (playerName.isEmpty()) playerName = "Player";

            Player player = new Player(
                playerName,
                RAND.nextInt(31) + 70, // HP 70〜100
                RAND.nextInt(9) + 10,  // AT 10〜18
                RAND.nextInt(8) + 5    // SP 5〜12
            );

            Daemon daemon = loadDaemon("src/curriculum_C/daemon_status.txt");

            System.out.println("\n--- 初期ステータス ---");
            System.out.println(player);
            System.out.println(daemon);
            log.append("[INIT] ").append(player).append("\n");
            log.append("[INIT] ").append(daemon).append("\n\n");

            Character attacker, defender;
            if (player.getSp() > daemon.getSp()) {
                attacker = player; defender = daemon;
            } else if (player.getSp() < daemon.getSp()) {
                attacker = daemon; defender = player;
            } else {
                if (RAND.nextBoolean()) { attacker = player; defender = daemon; }
                else { attacker = daemon; defender = player; }
            }

            System.out.println("先攻は " + attacker.getName() + " です！");
            log.append("[TURN ORDER] First: ").append(attacker.getName()).append("\n\n");

            int turn = 1;
            while (player.isAlive() && daemon.isAlive()) {
                System.out.println("=== Turn " + turn + " ===");

                int dmg = attacker.attack(defender);
                String line = attacker.getName() + " の攻撃！ → " + defender.getName()
                        + " に " + dmg + " ダメージ（残HP: " + Math.max(0, defender.getHp()) + ")";
                System.out.println(line);
                log.append("[TURN ").append(turn).append("] ").append(line).append("\n");

                if (!defender.isAlive()) break;

                Character tmp = attacker; attacker = defender; defender = tmp;
                turn++;
            }

            String winner = player.isAlive() ? player.getName() : daemon.getName();
            String result = "\n勝者: " + winner;
            System.out.println(result);
            log.append(result).append("\n");

            writeLog(log.toString());
        } catch (IOException e) {
            System.err.println("Daemonの読み込みに失敗しました: " + e.getMessage());
            System.err.println("※ src/curriculum_C 内に daemon_status.txt を置いてください（4行：名前/HP/AT/SP）");
        }
    }

    // ==============================
    // ファイル関連
    // ==============================
    private static Daemon loadDaemon(String path) throws IOException {
        System.out.println("[DEBUG] 読み込みパス: " + Paths.get(path).toAbsolutePath());
        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        if (lines.size() < 4) throw new IOException("daemon_status.txt のフォーマットが不正です（4行必要）");
        String name = lines.get(0).trim();
        int hp = Integer.parseInt(lines.get(1).trim());
        int at = Integer.parseInt(lines.get(2).trim());
        int sp = Integer.parseInt(lines.get(3).trim());
        return new Daemon(name, hp, at, sp);
    }

    private static void writeLog(String logText) {
        try {
            Files.write(
                Paths.get("battle_log.txt"),
                logText.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            System.err.println("battle_log.txt への書き込みに失敗: " + e.getMessage());
        }
    }
}

// ==============================
// CPUクラス（じゃんけん用）
// ==============================
class CPU {
    private Random rand = new Random();
    public int getHand() { return rand.nextInt(3); }
    public String handToString(int hand) {
        switch (hand) {
            case 0: return "グー";
            case 1: return "チョキ";
            case 2: return "パー";
            default: return "不明";
        }
    }
}

// ==============================
// キャラクター共通クラス
// ==============================
abstract class Character {
    private final String name;
    private int hp;
    private final int at;
    private final int sp;

    protected Character(String name, int hp, int at, int sp) {
        this.name = name;
        this.hp = hp;
        this.at = at;
        this.sp = sp;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAt() { return at; }
    public int getSp() { return sp; }
    public boolean isAlive() { return hp > 0; }

    public int attack(Character target) {
        int damage = Math.max(1, this.at);
        target.hp = Math.max(0, target.hp - damage);
        return damage;
    }

    @Override
    public String toString() {
        return String.format("%s [HP=%d, AT=%d, SP=%d]", name, hp, at, sp);
    }
}

// ==============================
// Player / Daemonクラス
// ==============================
class Player extends Character {
    public Player(String name, int hp, int at, int sp) {
        super(name, hp, at, sp);
    }
}

class Daemon extends Character {
    public Daemon(String name, int hp, int at, int sp) {
        super(name, hp, at, sp);
    }
}
