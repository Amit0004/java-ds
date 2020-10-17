package aa.data.structure;

public class BinaryTreeNode {
	public int data;
	BinaryTreeNode left, right;
	
	public BinaryTreeNode(int element) {
		this.data = element;
		left = null;
		right = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setRight(BinaryTreeNode node) {
		this.right = node;
	}
	
	public BinaryTreeNode getRight() {
		return this.right;
	}
	
	public void setLeft(BinaryTreeNode node) {
		this.left =  node;
	}
	
	public BinaryTreeNode getLeft() {
		return this.left;
	}
}
