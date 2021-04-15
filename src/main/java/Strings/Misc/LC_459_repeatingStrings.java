package Strings.Misc;

public class LC_459_repeatingStrings {

    public static boolean repeatedSubstringPattern(String s) {
        if(s==null){
            return false;
        }

        int start=0;
        int end=1;
        while(2*end-start<=s.length()){
            if(s.substring(start,end).equals(s.substring(end,end+(end-start)))){
                if(s.length()%(end-start)==0&&checkIfStringMadeUpSubString(s,start,end)){
                    return true;
                }
            }
            end=end+1;
        }

        return false;

    }

    public static boolean checkIfStringMadeUpSubString(String s, int i, int j ){

        String sub = s.substring(i,j);
        int new_i=0,new_j=0;
        new_i=j;
        new_j=j+(j-i);
        i=new_i;
        j=new_j;

        while(j<=s.length()){
            if(!s.substring(i,j).equals(sub)) {
                return false;
            }
            new_i=j;
            new_j=j+(j-i);
            i=new_i;
            j=new_j;
        }

        return true;
    }

    public static void main(String[] args) {
        //System.out.println(repeatedSubstringPattern("abab"));
        //System.out.println(repeatedSubstringPattern("abac"));
        //System.out.println(repeatedSubstringPattern("abcabcabc"));
        System.out.println(repeatedSubstringPattern("ababba"));
    }

    public static boolean repeatedSubstringPattern_recommended(String s) {
        if(s==null){
            return false;
        }

        int l = s.length();

        for(int i=l/2;i>=1;i--){

            if(l%i==0){
                int m = l/i;
                String sub = s.substring(0,i);
                StringBuilder sb = new StringBuilder();

                for(int k=0;k<m;k++){
                    sb.append(sub);
                }

                if(sb.toString().equals(s)){
                    return true;
                }

            }

        }

        return false;

    }
}
