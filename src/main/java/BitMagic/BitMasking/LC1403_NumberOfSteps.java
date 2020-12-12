package BitMagic.BitMasking;

public class LC1403_NumberOfSteps {

	public int numSteps(String s) {
		if (s == null || s.equals("")||s.equals("0")) {
			return 0;
		}

		return countHelper(s, 0);
	}

	public int countHelper(String s, int count) {
		if (s.equals("1")) {
			return count;
		}

		// even
		if (s.charAt(s.length() - 1) == '0') {
			return countHelper(s.substring(0, s.length() - 1), count + 1);
		} else {

			return countHelper(addOne(s), count + 1);
		}

	}

	public String addOne(String s) {

		int carry = 1;
		int sum = 0;
		char[] c = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = c.length - 1; i >= 0; i--) {
			sum = (int) (c[i] - '0') + carry;
			if (sum <= 1) {
				sb.append((char) (sum + '0'));
				carry = 0;
			} else if (sum == 2) {
				sb.append('0');
				carry = 1;
			} else {
				// throw exception
			}

		}

		if (carry == 1) {
			sb.append('1');
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		LC1403_NumberOfSteps lc = new LC1403_NumberOfSteps();
		System.out.println(lc.numSteps("11101111110010"));
	}
}
