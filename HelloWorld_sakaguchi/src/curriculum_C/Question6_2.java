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

public class Question6_2 {
    private static final Random RAND = new Random();

    // Daemon読み込み
    private static Daemon loadDaemon(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        if (lines.size() < 4) throw new IOException("daemon_status.txt のフォーマットが不正です（4行必要）");
        String name = lines.get(0).trim();
        int hp = Integer.parseInt(lines.get(1).trim());
        int at = Integer.parseInt(lines.get(2).trim());
        int sp = Integer.parseInt(lines.get(3).trim());
        return new Daemon(name, hp, at, sp);
    }

    // バトルログ書き出し
    private static void writeLog(String logText) {
        try {
            Files.write(
                Paths.get("battle_log.txt"),
                logText.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            System.err.println("battle_log.txt の書き込みに失敗: " + e.getMessage());
        }
    }

    // メインメソッド
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        log.append("=== Player vs Daemon === ").append(LocalDateTime.now()).append("\n");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("プレイヤー名を入力してください: ");
            String playerName = sc.nextLine().trim();
            if (playerName.isEmpty()) playerName = "Player";

            Player player = new Player(
                playerName,
                RAND.nextInt(31) + 70, // HP: 70〜100
                RAND.nextInt(9) + 10,  // AT: 10〜18
                RAND.nextInt(8) + 5    // SP: 5〜12
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
        }
    }
}

// ========== Character共通クラス ==========
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

// ========== Player / Daemon ==========
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
