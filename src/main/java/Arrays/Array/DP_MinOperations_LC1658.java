package Arrays.Array;

public class DP_MinOperations_LC1658 {


    public int minOperations(int[] nums, int x) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        return dp(0, nums.length - 1, nums, x, 0);
    }

    public int dp(int start, int end, int[] nums, int target, int ops) {
        if (target == 0) {
            return ops;
        }

        if (target < 0) {
            return -1;
        }

        if (start > end || start >= nums.length || end < 0) {
            return -1;
        }

        int chooseFirst = dp(start + 1, end, nums, target - nums[start], ops + 1);
        int chooseLast = dp(start, end - 1, nums, target - nums[end], ops + 1);

        if (chooseFirst == -1 && chooseLast == -1) {
            return -1;
        }

        if (chooseFirst == -1) {
            return chooseLast;
        }

        if (chooseLast == -1) {
            return chooseFirst;
        }

        return Math.min(chooseFirst, chooseLast);
    }

    public static void main(String[] args) {
        DP_MinOperations_LC1658 me = new DP_MinOperations_LC1658();
        System.out.println(me.minOperations(new int[]{2,-1,-1,3,4,5,2,3},10));
    }
}
