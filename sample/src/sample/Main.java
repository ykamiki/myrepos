package sample;

public class Main {

	public static void main(String[] args) {
		int num = 10;
		boolean ret = num < 10;
		System.out.println(ret);
		if (num < 10) {
			System.out.println(num + "です。");
		} else {
			System.out.println((num < 10) + "です。");
		}
	}

}
