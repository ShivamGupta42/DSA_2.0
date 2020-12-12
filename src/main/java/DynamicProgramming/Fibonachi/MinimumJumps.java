package DynamicProgramming.Fibonachi;

public class MinimumJumps {

	public static void main(String[] args) {
		MinimumJumps aj = new MinimumJumps();
		int[] jumps = { 2, 1, 1, 1, 4 };
		System.out.println(aj.countMinJumps(jumps, 0));
		jumps = new int[] { 1, 1, 3, 6, 9, 3, 0, 1, 3 };
		System.out.println(aj.countMinJumps(jumps, 0));
	}

	private int countMinJumps(int[] jumps, int index) {

		if (index == jumps.length - 1) {
			return 0;
		}
      
		if (index >= jumps.length||jumps[index]==0) {
			return Integer.MAX_VALUE;
		}

		int num = jumps[index];

		int curJumps = 0;
		int minJumps = Integer.MAX_VALUE;

		for (int i = index+1; i <= num; i++) {
			curJumps = countMinJumps(jumps, i) == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + curJumps;
			minJumps = Math.min(curJumps, minJumps);
		}

		return minJumps;
	}

	private int countMinJumps(int[] jumps, Integer[] dp) {

		return -1;
	}

}
