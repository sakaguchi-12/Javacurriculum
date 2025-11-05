package curriculum_B;

public class Selfint {
	
		  public static void main(String[] args) {
		    // 🟢 問題5：weight（60）を引数に追加
		    Person person1 = new Person("鈴木太郎", 20, 1.7, 60.0);

		    // 🟢 問題9：自己紹介とBMIを出力
		    person1.print();

		    // 🟢 問題10：合計人数を出力
		    Person.printCount();
		  }
		}

		// =======================================
		// 🧍 Personクラス（同じファイル内）
		// =======================================
		class Person {
		  // 🟢 問題4：フィールド定義
		  String name;
		  int age;
		  double height;
		  double weight;

		  // 🟢 問題10用（人数カウント）
		  static int count = 0;

		  // 🟢 問題2〜5：コンストラクタ
		  Person(String name, int age, double height, double weight) {
		    this.name = name;
		    this.age = age;
		    this.height = height;
		    this.weight = weight;
		    count++; // 生成された人数をカウント
		  }

		  // 🟢 問題6〜7：BMIを返すメソッド
		  double bmi() {
		    return this.weight / (this.height * this.height);
		  }

		  // 🟢 問題8〜9：自己紹介メソッド
		  void print() {
		    System.out.println("名前は" + this.name + "です");
		    System.out.println("年は" + this.age + "です");
		    System.out.printf("BMIは%.2fです%n", this.bmi()); // 小数点以下2桁で出力
		  }

		  // 🟢 問題10：人数の合計出力メソッド
		  static void printCount() {
		    System.out.println("合計" + count + "人です");
		  }
		}
