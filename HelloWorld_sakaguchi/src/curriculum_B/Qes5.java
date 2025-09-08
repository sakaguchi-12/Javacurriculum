package curriculum_B;

public class Qes5 {
    // Q1: helloWorld メソッドを定義
    public static void helloWorld() {
        System.out.println("Hello, World!");
    }

    // Q2: 整数を2倍にするメソッド
    public static int doubleValue(int num) {
        return num * 2;
    }

    // Q3: 偶数判定メソッド
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        // === Q1 実行 ===
        helloWorld();

        // === Q2 実行 ===
        int value = 10;
        int result = doubleValue(value);
        System.out.println(value + " を 2 倍すると " + result + " です。");

        // === Q3 実行 ===
        int num1 = 7;
        int num2 = 10;
        System.out.println(num2 + (isEven(num2) ? " は偶数です。" : " は奇数です。"));
        System.out.println(num1 + (isEven(num1) ? " は偶数です。" : " は奇数です。"));

        // === Q4 実行 ===
        Greeting greeting = new Greeting();
        greeting.sayHello();

        // === Q5 実行 ===
        Animal lion = new Animal();
        lion.setName("ライオン");
        lion.setLength(2.1);
        lion.setSpeed(80);

        System.out.println("動物名：" + lion.getName());
        System.out.println("体長：" + lion.getLength() + "m");
        System.out.println("速度：" + lion.getSpeed() + "km/h");
    }
}

// Q4用の別クラス
class Greeting {
    public void sayHello() {
        System.out.println("こんにちは！");
    }
}

// Q5用の別クラス
class Animal {
    private String name;   // 動物名
    private double length; // 体長
    private int speed;     // 速度

    public void setName(String name) { this.name = name; }
    public void setLength(double length) { this.length = length; }
    public void setSpeed(int speed) { this.speed = speed; }

    public String getName() { return this.name; }
    public double getLength() { return this.length; }
    public int getSpeed() { return this.speed; }
}
