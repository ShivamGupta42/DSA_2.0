package Search.modifiedBS;

public class FirstOccurence {

    public static int find_first_occurrence(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                if (mid == 0) {
                    return 0;
                } else if (arr[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {

                left = mid + 1;
            }

        }

        return -1;
    }
}

