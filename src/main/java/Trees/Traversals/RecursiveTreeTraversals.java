package Trees.Traversals;

public class RecursiveTreeTraversals {

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
		InOrderTraversal(root.left);
		System.out.print(root.value + " ");
		InOrderTraversal(root.right);
	}

	static <T> void preOrderTraversal(Node<T> root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	static <T> void postOrderTraversal(Node<T> root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.value + " ");
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
