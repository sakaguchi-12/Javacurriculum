package curriculum_B;

public class Selfint {
	
		  public static void main(String[] args) {
		    // 問題5
		    Person person1 = new Person("鈴木太郎", 20, 1.7, 60.0);

		    // 問題9
		    person1.print();

		    // 問題10
		    Person.printCount();
		  }
		}

		// Personクラス
		class Person {
		  // 
		  String name;
		  int age;
		  double height;
		  double weight;

		  // 問題10用
		  static int count = 0;

		  // 問題2〜5
		  Person(String name, int age, double height, double weight) {
		    this.name = name;
		    this.age = age;
		    this.height = height;
		    this.weight = weight;
		    count++; 
		  }

		  // 問題6〜7
		  double bmi() {
		    return this.weight / (this.height * this.height);
		  }

		  // 問題8〜9
		  void print() {
		    System.out.println("名前は" + this.name + "です");
		    System.out.println("年は" + this.age + "です");
		    System.out.printf("BMIは%.2fです%n", this.bmi()); // 小数点以下2桁で出力
		  }

		  // 問題10
		  static void printCount() {
		    System.out.println("合計" + count + "人です");
		  }
		}
