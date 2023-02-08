package pkg7;

public class BinarySearchTree {
	
	private TreeNode root;
	
	BinarySearchTree(){
		root = null;
	}
	
	
	public TreeNode search(int data) {
		
		if (root != null) {
			return root.search (data);
		}
		
		System.out.println("Unable to search, BST not initialized!");
		return null;
	}
	
	public void insert(int data) {
		if (root == null) {
			root = new TreeNode(data);
		}
		else {
			root.insert(data);
		}
		
	}
	/*
	public void delete (int data) {	
		if (root != null) {
			TreeNode currentNode = this.root;
			TreeNode parent = this.root;
			boolean isLeftChild = false;
			
			if (currentNode == null)
				return;
			
			while (currentNode != null && currentNode.getData() != data) {
				parent = currentNode;
				
				if (data < currentNode.getData()) {
					currentNode = currentNode.getLeftChild();
					isLeftChild = true;
				}
				else {
					currentNode = currentNode.getRightChild();
					isLeftChild = false;
				}
			}
			
			if (currentNode == null)
				return;
			
			if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
				if (currentNode == root) {
					root = null;
				}
				else {
					if (isLeftChild)
						parent.setLeftChild(null);
					else
						parent.setRightChild(null);
				}
				
			}
			else if (currentNode.getRightChild() ==  null){
				if (currentNode == root) {
					root = currentNode.getLeftChild();
				}
				else if (isLeftChild) {
					parent.setLeftChild(currentNode.getLeftChild());
				}
				else {
					parent.setRightChild(currentNode.getLeftChild());
				}
			}
			
			else if (currentNode.getLeftChild() ==  null){
				if (currentNode == root) {
					root = currentNode.getRightChild();
				}
				else if (isLeftChild) {
					parent.setLeftChild(currentNode.getRightChild());
				}
				else {
					parent.setRightChild(currentNode.getRightChild());
				}
		
			}
			
			
						
		}
	 	
		
		System.out.println("Unable to delete, BST not initialized!");
		
		
		
	}
		*/
	
	public void softDelete(int data) {
		TreeNode toDel = search(data);
		toDel.softDelete();
	}
	
	public Integer findMin() {
		if (this.root != null) {
			return root.findMin();
		}
		return null;
	}
	
	public Integer findMax() {
		if (this.root != null) {
			return root.findMax();
		}
		return null;
	}
	
	public void inOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		
		inOrderTraversal(node.getLeftChild());
		System.out.print(node.getKey() + " ");
		inOrderTraversal(node.getRightChild());

	}
	
	public void preOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.getKey() + " ");
		preOrderTraversal(node.getLeftChild());
		preOrderTraversal(node.getRightChild());
	}
	
	public void postOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		
		postOrderTraversal(node.getLeftChild());
		postOrderTraversal(node.getRightChild());
		System.out.print(node.getKey() + " ");
		
	}
	
}
