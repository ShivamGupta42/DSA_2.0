package LinkedLists;

public class twoSorted {

	static class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data+"";
		}

	}

	static class LinkList {
		LinkedListNode head;
		LinkedListNode tail;

		public LinkList(int data) {
			head = new LinkedListNode(data);
			tail = head;
		}

		void setNext(int data) {
			tail.next = new LinkedListNode(data);
			tail=tail.next;
		}
	}

	public static LinkedListNode merge_sorted(LinkedListNode head1, LinkedListNode head2) {

		if (head1 == null) {
			return head2;
		}

		if (head2 == null) {
			return head1;
		}

		LinkedListNode head = null;
		LinkedListNode tail = null;

		if (head1.data > head2.data) {
			head = head2;
			tail = head2;
			head2 = head.next;
		} else if (head1.data < head2.data) {
			head = head1;
			tail = head1;
			head1 = head1.next;
		} else {
			head = head1;
			tail = head1;
			head1 = head1.next;
			head2 = head2.next;
		}

		while (head1 != null && head2 != null) {

			if (head1.data > head2.data) {
				if (tail.data != head2.data) {
					tail.next = head2;
					tail=tail.next;
				}
				head2 = head2.next;
			} else if (head1.data < head2.data) {

				if (tail.data != head1.data) {
					tail.next = head1;
					tail=tail.next;
				}

				head1 = head1.next;
			} else {
				if (tail.data != head1.data) {
					tail.next = head1;
					tail=tail.next;
				}
				head1 = head1.next;
				head2 = head2.next;
			}

		}

		while (head1 != null) {
			if (tail.data != head1.data) {
				tail.next = head1;
				tail=tail.next;
			}
			head1 = head1.next;
		}

		while (head2 != null) {
			if (tail.data != head2.data) {
				tail.next = head2;
				tail=tail.next;
			}

			head2 = head2.next;
		}

		return head;
	}

	public static void main(String[] args) {
		LinkList link1 = new LinkList(1);
		link1.setNext(3);
		link1.setNext(5);
		link1.setNext(7);

		LinkList link2 = new LinkList(2);
		link2.setNext(4);
		link2.setNext(6);
		link2.setNext(8);

		LinkedListNode merged = merge_sorted(link1.head, link2.head);

		while (merged != null) {
			System.out.print(merged.data + " ");
			merged = merged.next;
		}
	}

}
