package Recursion;

public class PrintNatural {

	public static void main(String[] args) {
		int n = 10;
		printRecurAsc(n);
	}

	private static void printRecurDesc(int n) {
		if (n <= 0)
			return;
		System.out.print(n + " ");
		printRecurDesc(n - 1);
	}

	private static void printRecurAsc(int n) {
		if (n == 0) {
			return;
		}
		printRecurAsc(n - 1);
		System.out.print(n + " ");
	}
}
