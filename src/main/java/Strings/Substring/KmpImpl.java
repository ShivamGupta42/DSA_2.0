package Strings.Substring;

public class KmpImpl {

	static int indexOf(String w, String p) {

		return -1;
	}

	static int[] lps(String p) {
		int[] lps = new int[p.length()];
		lps[0] = 0;

		// length of the longest prefix
		// abdab
		int len = 0;
		int i = 1;
		while (i < p.length()) {
			if (p.charAt(i) == p.charAt(len)) {
				lps[i] = ++len;
				i++;
			} else {
				 //we don't update i in this context
                 if(len!=0) {
                	 len=lps[len-1];
                 } 
                  //len=0
                  else {
                	 lps[i]=len;
                	 i++;
                 }
			}

		}
		
		

		return lps;
	}

}
