package Trees.Traversals;

import java.util.Deque;
import java.util.LinkedList;

public class StackTreeTraversals {

	static class Node<T> {
		Node left;
		Node right;
		T value;

		public Node(T value) {
			this.value = value;
		}
	}

	static <T> void InOrderTraversal(Node<T> root) {
		if (root == null)
			return;

		Deque<Node<T>> q = new LinkedList<Node<T>>();
		Node<T> current = root;

		while (current != null || !q.isEmpty()) {

			while (current != null) {
				q.push(current);
				current = current.left;
			}

			current = q.pop();
			System.out.print(current.value + " ");
			current = current.right;
		}

	}

	static <T> void preOrderTraversal(Node<T> root) {
		if (root == null)
			return;

		Deque<Node<T>> q = new LinkedList<Node<T>>();
		q.push(root);

		while (!q.isEmpty()) {
			Node<T> temp = q.pop();
			System.out.print(temp.value + " ");
			if (temp.right != null) {
				q.push(temp.right);
			}

			if (temp.left != null) {
				q.push(temp.left);
			}
		}

	}

	static <T> void postOrderTraversal(Node<T> root) {
		if (root == null)
			return;

		Deque<Node<T>> q = new LinkedList<Node<T>>();
		Deque<Node<T>> res = new LinkedList<Node<T>>();
		q.push(root);

		while (!q.isEmpty()) {
			Node temp = q.pop();
			res.push(temp);

			if (temp.left != null) {
				q.push(temp.left);
			}

			if (temp.right != null) {
				q.push(temp.right);
			}
		}

		while (!res.isEmpty()) {
			System.out.print(res.pop().value + " ");
		}
	}

	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(7);
		root.left = new Node<Integer>(5);
		root.left.left = new Node<Integer>(1);
		root.left.right = new Node<Integer>(2);

		root.right = new Node<Integer>(6);
		root.right.left = new Node<Integer>(3);
		root.right.right = new Node<Integer>(4);

		InOrderTraversal(root);
		System.out.println();
		preOrderTraversal(root);
		System.out.println();
		postOrderTraversal(root);

	}

}
