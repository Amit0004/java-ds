package aa.data.structure;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class TreeOperation {
	BinaryTreeNode root;
	Queue<BinaryTreeNode> q = new java.util.LinkedList<BinaryTreeNode>();
	
	public void insertElement(int element) {
		if(root == null) {
			root = new BinaryTreeNode(element);
		} else {
			q.offer(root);
			while(!q.isEmpty()) {
				BinaryTreeNode temp = q.poll();
				if(temp != null) {
					if(temp.getRight() != null) {
						q.offer(temp.getRight());
					} else {
						temp.setRight(new BinaryTreeNode(element));
						return;
					}
					if(temp.getLeft() != null) {
						q.offer(temp.getLeft());
					} else {
						temp.setLeft(new BinaryTreeNode(element));
						return;
					}
				}
			}
		}
	}
	
	public void preOrderTraversal(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		if(root != null) {
			System.out.print(root.getData() + " ");
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}
	
	public void inOrderTraversal(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		if(root != null) {
			inOrderTraversal(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrderTraversal(root.getRight());
		}
	}
	
	public void postOrderTraversal(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		if(root != null) {
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}
	
	public void levelOrderTraversal(BinaryTreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root == null) {
//			System.out.println("[]");
			return;
		}
		Queue<BinaryTreeNode> q = new java.util.LinkedList<BinaryTreeNode>();
		q.offer(root);
		ArrayList<Integer> curr = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if(temp != null) {
				curr.add(temp.getData());
				System.out.print(temp.getData() + " ");
				if(temp.getLeft() != null) {
					q.offer(temp.getLeft());
				}
				if(temp.getRight() != null) {
					q.offer(temp.getRight());
				} 
			} else {
				ArrayList<Integer> cCurr = new ArrayList<Integer>(curr);
				res.add(cCurr);
				curr.clear();
				if(!q.isEmpty()) {
					q.offer(null);
				}
			}
		}
//		System.out.println(res);
	}
	
	public BinaryTreeNode getRoot() {
		return this.root;
	}
	
	// recursive method of insertion
	public void insertRecursively(int element) {
		if(root == null) {
			root = new BinaryTreeNode(element);
		} else {
			insertHelper(root, element);
		}
	}
	private void insertHelper(BinaryTreeNode root, int data) {
		if(root.getData() >= data) {
			if(root.getLeft() == null) {
				root.setLeft(new BinaryTreeNode(data));;
			} else {
				insertHelper(root.getRight(), data);
			}
		} else {
			if(root.getRight() == null) {
				root.setRight(new BinaryTreeNode(data));
			} else {
				insertHelper(root.getRight(), data);
			}
		}
	}
	
	// non recursive method of insertion
	public BinaryTreeNode insertInLevelOrder(BinaryTreeNode root, int data) {
		if(root == null) {
//			root = new BinaryTreeNode(data);
			return null;
		}
		Queue<BinaryTreeNode> q = new java.util.LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if(temp != null) {
				if(temp.getLeft() != null) {
					q.offer(temp.getLeft());
				} else {
					temp.setLeft(new BinaryTreeNode(data));
					return root;
				}
				if(temp.getRight() != null) {
					q.offer(temp.getRight());
				} else {
					temp.setRight(new BinaryTreeNode(data));
					return root;
				}
			}
		}
		return root;
	}
	
	// find max element recursively
	public int maxValueInTree(BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if(root != null) {
			int leftMax = maxValueInTree(root.getLeft());
			int rightMax = maxValueInTree(root.getRight());
			if(leftMax > rightMax) {
				maxValue = leftMax;
			} else {
				maxValue = rightMax;
			}
			if(root.getData() > maxValue) {
				maxValue = root.getData();
			}
		}
		return maxValue;
	}
	
	// find max element non recursively
	public int getMaxNonRecursively(BinaryTreeNode root) {
		int max = Integer.MIN_VALUE;
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		Queue<BinaryTreeNode> q = new java.util.LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if(tmp.getData() > max) {
				max = tmp.getData();
			}
			if(tmp != null) {
				if(tmp.getLeft() != null) {
					q.offer(tmp.getLeft());
				}
				if(tmp.getRight() != null) {
					q.offer(tmp.getRight());
				}
			}
		}
		return max;
	}
	
	// search and element recursively
	public boolean contains(BinaryTreeNode root, int element) {
		if(root == null) {
			return false;
		} else {
			if(root.getData() == element) {
				return true;
			}
			return contains(root.getLeft(), element) || contains(root.getRight(), element);
		}
	}
	
	// search an element non recursively
	public boolean containsNonRecursively(BinaryTreeNode root, int element) {
		boolean found = false;
		if(root == null) {
			return false;
		}
		Queue<BinaryTreeNode> q = new java.util.LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if(tmp.getData() == element) {
				found = true;
			}
			if(tmp != null) {
				if(tmp.getLeft() != null) {
					q.offer(tmp.getLeft());
				}
				if(tmp.getRight() != null) {
					q.offer(tmp.getRight());
				}
			}
		}
		
		return found;
	}
	
	// calculate size of the binary tree recursively
	public int sizeRecursively(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		} else {
			int left = root.getLeft() == null ? 0 : sizeRecursively(root.getLeft());
			int right = root.getRight() == null ? 0 : sizeRecursively(root.getRight());
			return 1 + left + right;
		}
	}
	
	
	// calculate size of the binary tree non recursively
	public int sizeNonRecursively(BinaryTreeNode root) {
		int count = 0;
		if(root == null) {
			return 0;
		} else {
			Queue<BinaryTreeNode> q = new java.util.LinkedList<BinaryTreeNode>();
			q.offer(root);
			while(!q.isEmpty()) {
				BinaryTreeNode temp = q.poll();
				count++;
				if(temp.getRight() != null) {
					q.offer(temp.getRight());
				}
				if(temp.getLeft() != null) {
					q.offer(temp.getLeft());
				}
			}
		}
		return count;
	}
	
	// delete a tree
	public void delete(BinaryTreeNode root) {
		root = null;
		return;
	}
	
	// print the level order traversal in reverse order
	public void reverse(BinaryTreeNode root) {
		if(root == null) {
			System.out.println("[]");
			return;
		} else {
			Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
			Queue<BinaryTreeNode> q = new java.util.LinkedList<BinaryTreeNode>();
			q.offer(root);
			while(!q.isEmpty()) {
				BinaryTreeNode temp = q.poll();
				if(temp.getLeft() != null) {
					q.offer(temp.getLeft());
				}
				if(temp.getRight() != null) {
					q.offer(temp.getRight());
				}
				s.push(temp);
			}
			while(!s.isEmpty()) {
				System.out.print(s.pop().getData() + " ");
			}
			System.out.println();
		}
	}
	
	// find height (or depth) of a binary tree
	public int height(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = height(root.getLeft());
		int rightHeight = height(root.getRight());
		return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
	}
	
	// find height (or depth) of a binary tree
	public int heightIterative(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		int maxDepth = 0;
		BinaryTreeNode prev = null;
		s.push(root);
		while(!s.isEmpty()) {
			BinaryTreeNode curr = s.peek();
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
				if(curr.getLeft() != null) {
					s.push(curr.getLeft());
				}
				if(curr.getRight() != null) {
					s.push(curr.getRight());
				}
			} else if(curr.getLeft() == prev) {
				if(curr.getRight() != null) {
					s.push(curr.getRight());
				} else {
					s.pop();
				}
			}
			if(s.size() > maxDepth) {
				maxDepth = s.size();
			}
		}
		return maxDepth;
	}
	
	
	// find height (or depth) using non recursive method
	public int heightNonRecursively(BinaryTreeNode root) {
		int count = 1;
		if(root == null) {
			return count;
		}
		Queue<BinaryTreeNode> q = new java.util.LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty()) {
			BinaryTreeNode currentNode = q.poll();
			if(currentNode != null) {
				if(currentNode.getRight() == null && currentNode.getLeft() == null) {
					return count;
				}
				if(currentNode.getLeft() != null) {
					q.offer(currentNode.getLeft());
				}
				if(currentNode.getRight() != null) {
					q.offer(currentNode.getRight());
				}
			} else {
				if(!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}
			
		}
		return count;
	}
	
	// method to find the deepest node in binary tree
	public BinaryTreeNode deepestNodeInTree(BinaryTreeNode root) {
		if(root == null) {
			return null;
		}
		Queue<BinaryTreeNode> q = new java.util.LinkedList<BinaryTreeNode>();
		q.offer(root);
		BinaryTreeNode temp = null;
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.getRight() != null) {
				q.offer(temp.getRight());
			}
			if(temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
		}
		return temp;
		
	}
	
	public static void main(String[] args) throws Exception {
		TreeOperation tree = new TreeOperation();
//		tree.insertElement(1);
//		tree.insertElement(2);
//		tree.insertElement(3);
//		tree.insertElement(4);
//		tree.insertElement(5);
//		tree.insertElement(6);
//		tree.insertElement(7);
		
//		tree.insertRecursively(1);
//		tree.insertRecursively(2);
//		tree.insertRecursively(3);
//		tree.insertRecursively(4);
//		tree.insertRecursively(5);
//		tree.insertRecursively(6);
//		tree.insertRecursively(7);
		BinaryTreeNode root = new BinaryTreeNode(1);
		root = tree.insertInLevelOrder(root, 2);
		root = tree.insertInLevelOrder(root, 3);
		root = tree.insertInLevelOrder(root, 4);
		root = tree.insertInLevelOrder(root, 5);
		root = tree.insertInLevelOrder(root, 6);
		root = tree.insertInLevelOrder(root, 7);
		root = tree.insertInLevelOrder(root, 8);
		root = tree.insertInLevelOrder(root, 9);
		root = tree.insertInLevelOrder(root, 10);
		root = tree.insertInLevelOrder(root, 11);
		tree.preOrderTraversal(root);
		System.out.println();
		tree.inOrderTraversal(root);
		System.out.println();
		tree.postOrderTraversal(root);
		System.out.println();
		tree.levelOrderTraversal(root);
//		tree.delete(root);
		System.out.println();
//		tree.reverse(root);
		System.out.println("Max Recursively: " + tree.maxValueInTree(root));
		System.out.println("Max Non Recursively: " + tree.getMaxNonRecursively(root));
		System.out.println("Search recursively: "+ tree.contains(root, 8));
		System.out.println("Search non recursively: "+ tree.containsNonRecursively(root, 8));
		System.out.println("Size recursively: " + tree.sizeRecursively(root.getRight()));
		System.out.println("Size non recursively: " + tree.sizeNonRecursively(root.getLeft()));
		System.out.println("Height: " + tree.height(root));
//		System.out.println("Height Iteratively: " + tree.heightIterative(root));
		System.out.println("Height Non Recursive: " + tree.heightNonRecursively(root));
		System.out.println("Deepest node: " + tree.deepestNodeInTree(root).getData());
	}
}
