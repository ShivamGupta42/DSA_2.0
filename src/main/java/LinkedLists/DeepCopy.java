package LinkedLists;

import java.util.IdentityHashMap;

public class DeepCopy {
       
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		Node newHead = new Node(head.val);
		Node ogHead = head;

		Node cur = newHead;
		cur.random = head;
		head = head.next;
		
		IdentityHashMap<Node, Node> map = new IdentityHashMap<>();
        map.put(head,cur);
		while (head != null) {
			cur.next = new Node(head.val);
			cur = cur.next;
			cur.random = head;
			map.put(head,cur);
			head = head.next;
		}

		cur = newHead;
		while (cur != null) {
			cur.random = map.get(cur.random);
			cur = cur.next;
		}

		return newHead;
	}
	
	

}
