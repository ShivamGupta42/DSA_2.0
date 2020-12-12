package BitMagic.BitMasking;

import java.util.ArrayList;

public class DifferentBitPairwise {

	public int cntBits1(ArrayList<Integer> A) {

		int sum = 0;
		int m = 1000000007;

		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {

				sum += countSetBits(A.get(i) ^ A.get(j));
				sum = sum % m;
			}

		}

		return (sum * 2) % m;

	}

	static int countSetBits(int x) {
		int count = 0;
		while (x != 0) {
			x = x & (x - 1);
			count++;
		}
		return count;
	}
	
	
	public int cntBits2(ArrayList<Integer> A) {

		int ans = 0; // Initialize result 
		int m = 1000000007;
		  
        // traverse over all bits 
        for (int i = 0; i < 32; i++) { 
              
            // count number of elements  
            // with i'th bit set 
            int count = 0; 
              
            for (int j = 0; j < A.size(); j++) {
                if ((A.get(j) & (1 << i)) != 0) 
                    count++; 
            }   
  
            // Add "count * (n - count) * 2"  
            // to the answer 
            ans += (count * (A.size() - count) * 2); 
            ans=ans%m;
        } 
          
        return ans%m; 

	}

}
