package ReadWorldProblems.Facebook;

/*
 Sync the Facebook stories list with Instagram.

-> Actually the insta impl puts all the story ids in an array which keeps getting rotated
due the watched stories being put into the back of the array
-> We need to find the storyId whenever a user clicks on any any story from the array
-> Basically binary search on a rotated array

 */
public class Feature3 {


    public static void main(String[] args) {
        int[] v1 = {6, 7, 1, 2, 3, 4, 5};
        System.out.println("Key(3) found at: " + FindStoryId(v1, 3));
        System.out.println("Key(6) found at: " + FindStoryId(v1, 6));

        int[] v2 = {4, 5, 6, 1, 2, 3};
        System.out.println("Key(3) found at: " + FindStoryId(v2, 3));
        System.out.println("Key(6) found at: " + FindStoryId(v2, 6));
    }

    private static int FindStoryId(int[] arr, int target) {
        int index = findPivot(arr, 0, arr.length);
        if(index==-1){
            return bs(arr,target,0,arr.length);
        }else if(arr[arr.length-1]<target){
            return bs(arr,target,0,index-1);
        }else{
            return bs(arr,target,index,arr.length);
        }
    }

    private static int findPivot(int[] arr, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == 0) {
                return 0;
            }
            if (mid == arr.length - 1) {
                return arr.length - 1;
            }

            if (arr[mid] <= arr[arr.length - 1] && arr[mid - 1] > arr[mid]) {
                return mid;
            } else if (arr[mid] <= arr[arr.length - 1] && arr[mid - 1] < arr[mid]) {
                return findPivot(arr, start, mid - 1);
            } else{
                return findPivot(arr, mid + 1, end);
            }
        }

        return -1;
    }

    private static int bs(int[] arr, int target, int start, int end) {

        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                return bs(arr, target, mid + 1, end);
            } else {
                return bs(arr, target, start, mid-1);
            }
        }

        return -1;
    }

}
