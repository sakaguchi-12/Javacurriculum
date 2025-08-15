package curriculum_B;

public class Qes2 {

	public static void main(String[] args) {
		// 1.　点数の判定
		int score = 75;
		if (score >= 60) {
		    System.out.println("合格です！");
		}

        //2. 年齢の判定
		int age = 25;
		if (age >= 20 && age <= 30) {
		    System.out.println("適正年齢です");
		} else {
		    System.out.println("対象外です");
		}

		//3.　年齢の判定２
		int age2 = 18;
		if (age2 >= 20) {
		    System.out.println("成人です");
		} else if (age2 >= 13 && age2 <= 19) {
		    System.out.println("ティーンエイジャーです");
		} else {
		    System.out.println("子供です");
		}
		 // 4. 一番大きい数値を判定
        int x = 30, y = 15, z = 50;
        if (x >= y && x >= z) {
            System.out.println("最大値は " + x);
        } else if (y >= x && y >= z) {
            System.out.println("最大値は " + y);
        } else {
            System.out.println("最大値は " + z);
        }

        // 5. num の正負判定
        int num = -5;
        if (num > 0) {
            System.out.println("正の数です");
        } else if (num == 0) {
            System.out.println("0 です");
        } else {
            System.out.println("負の数です");
        }

        // 6. 偶数・奇数判定
        int value = 11;
        if (value % 2 == 0) {
            System.out.println("偶数です");
        } else {
            System.out.println("奇数です");
        }

        // 7. 成績判定
        int score2 = 85;
        if (score2 >= 90) {
            System.out.println("優");
        } else if (score2 >= 70) {
            System.out.println("良");
        } else if (score2 >= 50) {
            System.out.println("可");
        } else {
            System.out.println("不可");
        }

        // 8. 入力が null または空文字かどうか判定
        String input = "";
        if (input == null || input.isEmpty()) {
            System.out.println("入力が無効です");
        } else {
            System.out.println("入力された値: " + input);
        }
        
        // 9. dayに応じて曜日を表示
        int day = 3; // 1～7を代入
        switch (day) {
            case 1:
                System.out.println("月曜日");
                break;
            case 2:
                System.out.println("火曜日");
                break;
            case 3:
                System.out.println("水曜日");
                break;
            case 4:
                System.out.println("木曜日");
                break;
            case 5:
                System.out.println("金曜日");
                break;
            case 6:
                System.out.println("土曜日");
                break;
            case 7:
                System.out.println("日曜日");
                break;
            default:
                System.out.println("無効な入力です");
        }

        // 10. monthに応じて季節を表示
        int month = 11; // 1～12を代入
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("冬");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋");
                break;
            default:
                System.out.println("無効な月です");
        }
        
	}

}
