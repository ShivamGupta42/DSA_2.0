package Arrays.Array;

import java.util.HashMap;

public class ConsecutivePieces_LC1640 {


    public static boolean canFormArray(int[] arr, int[][] pieces) {

        HashMap<Integer,int[]> pieceMap = new HashMap<>();

        for(int i=0;i<pieces.length;i++){
            pieceMap.put(pieces[i][0],pieces[i]);
        }


        for(int i =0;i<arr.length;){

            if(pieceMap.get(arr[i])!=null){
                int length = pieceMap.get(arr[i]).length;
                int[] piece = pieceMap.get(arr[i]);
                int start=0;
                while(start!=length){
                    if(arr[i]!=piece[start]){
                        return false;
                    }
                    start++;
                    i++;
                }
            }
            else{
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
         int[] arr = {91,4,64,78};
         int[][] pieces = {{78},{4,64},{91}};
        System.out.println(canFormArray(arr,pieces));

    }


}
