package Maths.factorial;

public class Digits {
	
	public static void main(String[] args) {
		System.out.println(digitsInFactorial(5));
		System.out.println(digitsInFactorial(0));
		System.out.println(digitsInFactorial(7));
	}
	
	 public static double  digitsInFactorial(int n)
	    {
	       if(n<3&&n>=0) return 1;
	       double sum=0;
	       for(int i=1;i<=n;i++){
	    	  sum+=Math.log10(i);
	       }
	       
	       return sum+1;
	    }

}
