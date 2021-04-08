package LinkedLists;

public class LC234_PalindromeList {
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

	public boolean isPalindrome(ListNode head) {
		ListNode ogHead=head;
		ListNode mid = findMid(head);
		ListNode newHead = reverseList(mid);
		ListNode cpNewHead = newHead;

		boolean result=true;
		
		while (head != null && newHead != null) {
			if (head.val != newHead.val) {
				result=false;
				break;
			}
			
			head=head.next;
			newHead=newHead.next;
		}

		reverseList(cpNewHead);
		return result;
	}

	public ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode temp = null;

		while (current != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}

		return prev;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1,1);
		l.next = new ListNode(2,2);
		l.next.next = new ListNode(3,1);
		l.next.next.next = new ListNode(4,1);

		LC234_PalindromeList obj = new LC234_PalindromeList();
		System.out.println(obj.isPalindrome(l));
	}


	public boolean isPalindrome2(ListNode head) {

		//find middle
		if(head==null){
			return false;
		}


		ListNode slow = head;
		ListNode fast= head;

		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}


		//find count of nodes
		ListNode cptr=head;
		int nCount=0;

		while(cptr!=null){
			nCount++;
			cptr=cptr.next;
		}

		//check for palindrome
		ListNode left = head;
		ListNode right=null;
		if(nCount%2!=0){
			right=slow.next;
		}else{
			right=slow;
		}

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		while(right!=null){
			sb1.append(left.val+"");
			sb2.append(right.val+"");
			left=left.next;
			right=right.next;
		}

		return sb1.toString().equals(sb2.reverse().toString());
	}

}
