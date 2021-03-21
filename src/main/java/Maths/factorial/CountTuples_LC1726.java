package Maths.factorial;

import java.util.HashMap;
import java.util.Map;

public class CountTuples_LC1726 {


    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192}));
        //System.out.println(tupleSameProduct(new int[]{2,3,4,6,8,12}));
    }

    public static int tupleSameProduct(int[] arr) {

        HashMap<Integer, Integer> multiples = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                int product = arr[i] * arr[j];

                multiples.compute(product, (k, v) -> {
                    if (v == null) {
                        return 1;
                    } else {
                        return v = v + 1;
                    }

                });
            }
        }//end of loop

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : multiples.entrySet()) {
            sum += getCombinations(entry.getValue());
        }

        return sum * 8;
    }

    public static int getCombinations(int n) {
        if (n <= 1) {
            return 0;
        }

        return (n*(n-1))/2;
    }


}

