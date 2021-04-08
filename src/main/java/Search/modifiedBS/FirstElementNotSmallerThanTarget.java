package Search.modifiedBS;



/*
 Finding first-occurrence type problem


 */
public class FirstElementNotSmallerThanTarget {

    public static int first_not_smaller(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                if (mid == 0) {
                    return 0;
                } else if (arr[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                    continue;
                }
            }
            left = mid + 1;

        }

        return -1;
    }
}
