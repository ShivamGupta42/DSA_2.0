package Maths.Array;

/*

Problem:
We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.

The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].

The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].

Return true if and only if the number of global inversions is equal to the number of local inversions.

Example 1:

Input: A = [1,0,2]
Output: true
Explanation: There is 1 global inversion, and 1 local inversion.
Example 2:

Input: A = [1,2,0]
Output: false
Explanation: There are 2 global inversions, and 1 local inversion.

 */


public class LC_775_Count_Inversions {

    /*Solution

    All local inversions are global ones with j=i+1
    If we can find any global inversion with A[i]>A[j] with j>=i+2 then it means it is not balanced
    it means if for any j, = i+2
    if(A[j]<Max(A[i](max element until A[i]) we have our answer

     */

    public boolean isIdealPermutation(int[] A) {
        if (A == null) {
            return false;
        }

        int aMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 2; i++) {
            aMax = Math.max(aMax, A[i]);
            if (aMax > A[i + 2]) {
                return false;
            }
        }

        return true;
    }


}
