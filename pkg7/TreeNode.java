package pkg7;

public class TreeNode {
	
	private int key;
	private TreeNode leftChild;
	private TreeNode rightChild;
	private boolean isDeleted = false;
	
	public TreeNode (Integer data) {
		this.key = data;
	}
	
	public TreeNode search (int x) {
		if (this.key == x && !isDeleted) {
			return this;
		}
		if (x < this.key && leftChild != null) {
			return leftChild.search(x);
		}
		
		if (x > this.key && rightChild != null) {
			return rightChild.search(x);
		}
		System.out.println ("unable to find data!");
		return null;
	}
	
	public void insert(int x) {
		if (x >= this.key) {
			if (this.rightChild == null) {
				this.rightChild = new TreeNode(x);
			}
			else {
				this.rightChild.insert(x);
			}
		}
		if (x < this.key){
			if(this.leftChild == null) {
				this.leftChild = new TreeNode(x);
			}
			else {
				this.leftChild.insert(x);
			}
		}
			
		
		
	}
		
	public int getKey() {
		return key;
	}
	
	
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public void softDelete() {
		this.isDeleted = true;
	}
	
	public int findMin() {
		if (this.leftChild == null) {
			return this.key;
		}
		return this.leftChild.findMin();
	}
	
	public int findMax() {
		if (this.rightChild == null) {
			return this.key;
		}
		return this.rightChild.findMax();
	}

}
