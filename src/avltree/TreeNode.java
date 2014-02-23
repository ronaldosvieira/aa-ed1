package avltree;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	private AVLTreeEntry entry;
	private int height;
	
	public TreeNode(AVLTreeEntry entry){
		this.entry = entry;
		this.right = this.left = null;
		this.height = 0;
	}
	
	public TreeNode(Comparable key, Object value){
		this.entry = new AVLTreeEntry(key, value);
		this.right = this.left = null;
		this.height = 0;
	}
	
	public void updateHeight(){
		int leftHeight = 0, rightHeight = 0;
		if(this.left != null) leftHeight = this.left.getHeight();
		if(this.right != null) rightHeight = this.right.getHeight();
		
		this.height = 1+Math.max(leftHeight,rightHeight);
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public Comparable<Object> getKey(){
		return this.entry.getKey();
	}
	
	public Object getValue(){
		return this.entry.getValue();
	}
	
	public AVLTreeEntry getEntry() {
		return this.entry;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.entry.getValue());
	}
}
