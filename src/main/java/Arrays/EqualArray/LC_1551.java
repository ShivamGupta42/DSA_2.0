package Arrays.EqualArray;

public class LC_1551 {

    public int minOperations(int n) {
        int mid=0;
        if(n%2==0){
            mid=n;
        }else{
            mid=2*(n/2)+1;
        }

        int end = n/2;
        int start=0;
        int ops=0;
        while(start<end){
            ops+=(mid-(2*(start++)+1));
        }

        return ops;
    }
}
