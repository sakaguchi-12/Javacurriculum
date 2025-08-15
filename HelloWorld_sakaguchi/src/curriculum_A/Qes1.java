package curriculum_A;

public class Qes1 {
    public static void main(String[] args) {

        // ===== 課題1：各型の変数を宣言して初期値を設定 =====
        byte byteNum = 0;
        short shortNum = 0;
        int intNum = 0;
        long longNum = 0L;
        float floatNum = 0.0f;
        double doubleNum = 0.0;
        char letter = '\u0000';
        String letters = null;
        boolean isBoolean = false;

        // ===== 課題2：指定された値を代入 =====
        byteNum = 10;
        shortNum = 100;
        intNum = 1000;
        longNum = 10000L;
        floatNum = 9.5f;
        doubleNum = 10.5;
        letter = 'a';
        letters = "ハロー";
        isBoolean = true;

        // ===== 課題3：変数を使って出力 =====
        // 11110
        System.out.println(byteNum + shortNum + intNum + longNum);

        // 20
        System.out.println(byteNum * 2);

        // a ハロー true
        System.out.println(letter + " " + letters + " " + isBoolean);

        // 11130（数値を全て足す）
        System.out.println(byteNum + shortNum + intNum + longNum + floatNum + doubleNum);

        // 10000000000（小数点以外の数字を掛ける）
        System.out.println((long)byteNum * shortNum * intNum * longNum);

        // 0.105（10.5 ÷ 100）
        System.out.println(doubleNum / 100);

        // -90（10 − 100）
        System.out.println(byteNum - shortNum);
        
        // =====課題4：nameをString型の変数にする ======
        String name = "山田太郎";
        		System.out.println("こんにちは、" + name + "さん！");
        		
        // =====課題5：ageを使った年齢表示 =====
        int age = 25;
        System.out.println("年齢:" + age +"歳");
        
        // ===== 課題6：計算結果をsumで表示する =====
        int num1 = 10;
        int num2 = 5;
        int sum = num1 + num2;
        System.out.println(sum);

        // ===== 課題7：scoreを使った表記 =====
        int score = 80;
        score += 20;
        System.out.println("最終スコア: " + score);

        // ===== 課題8：整数のみの表記に変更する =====
        double price = 99.99;
        int priceInt = (int) price;
        System.out.println("整数価格: " + priceInt);

        // ===== 課題9：型の変換 =====
        String numStr = "123";
        int numConverted = Integer.parseInt(numStr);
        System.out.println("変換後の値: " + (numConverted + 10));

        // ===== 課題10：int型→String型 =====
        int num = 50;
        String numAsString = String.valueOf(num);
        System.out.println("得点: " + numAsString + "点");

        // ===== 課題11：条件演算子を使う =====
        int a = 10;
        int b = 20;
        boolean result = a < b ? true : false;
        System.out.println(result);

        // ===== 課題12：三項演算子 =====
        int x = 15;
        String judge = (x >= 10) ? "OK" : "NG";
        System.out.println(judge);

        // ===== 課題13：置き換え =====
        String text = "私はJavaが好きです。Javaは楽しい！";
        String replaced = text.replace("Java", "Python");
        System.out.println(replaced);
    }
}
