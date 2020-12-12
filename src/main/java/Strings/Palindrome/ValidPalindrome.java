package Strings.Palindrome;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() < 2) {
			return true;
		}

		s = s.toLowerCase();
		int start = 0;
		int end = s.length() - 1;
		char a = 'a', b = 'b';

		while (start < end) {
			a = s.charAt(start);
			b = s.charAt(end);

			while (((a - 'a') < 0 || (a - 'a') > 25 || (a - '0') < 0 || (a - '0') > 9) && start < end) {
				
				a = s.charAt(++start);
			}

			while (((b - 'a') < 0 || (b - 'a') > 25 || (b - '0') < 0 || (b - '0') > 9) && start < end) {
				b = s.charAt(--end);
			}

			if (a != b) {
				return false;
			}

			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("race a car"));
	}

}
