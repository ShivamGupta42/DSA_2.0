package LinkedLists;

public class LC92_ReverseLinkListMN {

	static class ListNode {
		public int id;
		public int val;
		public ListNode next;

		public ListNode(int id, int val) {
			this.id = id;
			this.val = val;
		}

		@Override
		public String toString() {
			return id + ":" + val;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0, 0);
		dummy.next = head;

		ListNode current = head;
		ListNode prev = null;
		ListNode temp = null;
		ListNode begin = dummy;
		ListNode remain = null;
		ListNode end = null;

		int i = 0;
		while (i++ < m) {
			begin = current;
			current = current.next;
			end = current;
		}
         
		while (i >= m && i <= n) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
			i++;
		}

		remain = current;
		begin.next = prev;
		end.next = remain;

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1, 1);
		l.next = new ListNode(2, 2);
		l.next.next = new ListNode(3, 3);
		l.next.next.next = new ListNode(4, 4);
		l.next.next.next.next = new ListNode(5, 5);

		ListNode ans = reverseBetween(l, 2, 4);
		while (ans != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}

	}

}
