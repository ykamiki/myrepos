package sample;

public class Main {

	public static void main(String[] args) {
		int[] nums = {2, 1, 5, 3, 4};
		int maxNum = 0;
		
		for (int num: nums) {
			maxNum = Math.max(maxNum, num);
		}
		System.out.println(maxNum);
	}

}
