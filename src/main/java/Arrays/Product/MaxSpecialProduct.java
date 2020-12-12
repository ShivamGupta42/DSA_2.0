package Arrays.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MaxSpecialProduct {

	public static int maxSpecialProduct(List<Integer> A) {
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];
        int m= 1000000007;
        
        int curMax=Integer.MIN_VALUE;
        int curMaxIndex=-1;
        
        
        for(int i=0;i<A.size();i++){
            if(A.get(i)>=curMax){
                curMax=A.get(i);
                curMaxIndex=i;
                left[i]=-1;
                continue;
            }
            left[i]=curMaxIndex;
        }
        
        curMax=Integer.MIN_VALUE;
        curMaxIndex=-1;
        
        for(int i=A.size()-1;i>=0;i--){
            if(A.get(i)>=curMax){
                curMax=A.get(i);
                curMaxIndex=i;
                right[i]=-1;
                continue;
            }   
            right[i]=curMaxIndex;
        }
        
        int maxProduct=Integer.MIN_VALUE;
        int curProduct=maxProduct;
        
        for(int i=1;i<A.size()-1;i++){
            if(left[i]==-1||right[i]==-1){
                curProduct=0;
            }
            
            else{
            
            int lv=left[i];
            int rv=right[i];
            for(int j= left[i]+1;j<i;j++) {
              	if(A.get(j)>A.get(i)) {
              		lv=j;
              	}
            }	
            
            for(int j= right[i]-1;j>i;j--) {
              	if(A.get(j)>A.get(i)) {
              		rv=j;
              	}
            }	
            
            curProduct=((lv%m)*(rv%m))%m;
            
            }
            
           if(curProduct>maxProduct){
               maxProduct=curProduct;
           }
        }
        
        return maxProduct%m;
        
        
    }
	
	
	
	public int maxSpecialProduct2(ArrayList<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];
        int m= 1000000007;
        
        left = nextGreaterInLeft(A,n);
        right = nextGreaterInRight(A,n);
        int maxProduct=Integer.MIN_VALUE;
        int curProduct=maxProduct;
        
        for(int i=0;i<A.size();i++){
            if(left[i]==-1||right[i]==-1){
                curProduct=0;
            }
            
            else{
            
            curProduct=(((left[i]-1)%m)*((right[i]-1)%m))%m;
            
            }
            
           if(curProduct>maxProduct){
               maxProduct=curProduct;
           }
        }
        
        return maxProduct%m;
        
    }
    
    static int[] nextGreaterInLeft(ArrayList<Integer> A,  
                                   int n) 
    { 
        int []left_index = new int[n]; 
        Stack<Integer> s = new Stack<Integer>(); 
      
        for (int i = n - 1; i >= 0; i--) 
        { 
      
            // checking if current  
            // element is greater than top 
            while (s.size() != 0 &&  
                     A.get(i) > A.get(s.peek() - 1)) 
            { 
                int r = s.peek(); 
                s.pop(); 
      
                // on index of top store  
                // the current element  
                // index which is just  
                // greater than top element 
                left_index[r - 1] = i + 1; 
            } 
      
            // else push the current 
            // element in stack 
            s.push(i + 1); 
        } 
        return left_index; 
    } 
      
      
     static int[] nextGreaterInRight(ArrayList<Integer> A,  
                                    int n) 
    { 
        int []right_index = new int[n]; 
        Stack<Integer> s = new Stack<Integer>(); 
        for (int i = 0; i < n; ++i) { 
      
            // checking if current element  
            // is greater than top 
            while (s.size() != 0 &&  
                        A.get(i) > A.get(s.peek() - 1))  
            { 
                int r = s.peek(); 
                s.pop(); 
      
                // on index of top store  
                // the current element index 
                // which is just greater than  
                // top element stored index  
                // should be start with 1 
                right_index[r - 1] = i + 1; 
            } 
      
            // else push the current  
            // element in stack 
            s.push(i + 1); 
        } 
        return right_index; 
    }   
	
	
	
	
	
	
	
	public static void main(String[] args) {
		List<Integer> list;
		int[] arr = {5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9};
		list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(maxSpecialProduct(list));
		
	}
}
