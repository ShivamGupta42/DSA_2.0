package Strings.Misc;

import java.util.Arrays;
import java.util.List;

public class LC_1704 {

    List<Character> vowels = Arrays.asList(new Character[]
            {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});

    public boolean halvesAreAlike(String s) {

        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        int x = 0, y = s.length() - 1;
        int xCount = 0, yCount = 0;

        while (x != y) {

            if (isVowel(s.charAt(x))) {
                xCount++;
            }

            if (isVowel(s.charAt(y))) {
                yCount++;
            }

            x++;
            y--;
        }

        if (xCount != yCount) {
            return false;
        }

        return true;

    }

    public boolean isVowel(char c) {
        return vowels.contains(c);
    }

    public static void main(String[] args) {
        LC_1704 obj = new LC_1704();
        System.out.println(obj.halvesAreAlike("book"));
    }
}
