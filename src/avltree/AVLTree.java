package avltree;

public class AVLTree {
	private TreeNode root;
	
	public AVLTree(){
		
	}
	
	private void leftRotation(){
		leftRotation(this.root);
	}
	
	private void rightRotation(){
		rightRotation(this.root);
	}
	
	private void doubleLeftRotation(){
		doubleLeftRotation(this.root);
	}
	
	private void doubleRightRotation(){
		doubleRightRotation(this.root);
	}
	
	private void leftRotation(TreeNode t){
		TreeNode temp = t.right;
		t.right = t.right.left;
		temp.left = t;
		t = temp;
		
		t.left.updateHeight();
		t.updateHeight();
	}
	
	private void rightRotation(TreeNode t){
		TreeNode temp = t.left;
		t.left = t.left.right;
		temp.right = t;
		t = temp;
		
		t.right.updateHeight();
		t.updateHeight();
	}
	
	private void doubleLeftRotation(TreeNode t){
		this.rightRotation(t.right);
		this.leftRotation(t);
	}
	
	private void doubleRightRotation(TreeNode t){
		this.leftRotation(t.right);
		this.rightRotation(t);
	}
	
	public void insert(TreeNode newNode){
		insert(newNode,this.root);
	}
	
	public void insert(TreeNode newNode,TreeNode node){
		if(this.root == null){
			this.root = newNode;
			this.root.updateHeight();
		}else if(node == null){
			node = newNode;
			node.updateHeight();
		}else{ 
			if(newNode.getEntry().keyLowerThan(node.getEntry().getKey())){
				insert(newNode,node.left);
				
				int leftHeight = 0, rightHeight = 0;
				if(node.left != null) leftHeight = node.left.getHeight();
				if(node.right != null) rightHeight = node.right.getHeight();
				
				if((leftHeight - rightHeight) == 2){
					if(newNode.getEntry().keyLowerThan(node.left.getEntry().getKey())) rightRotation(node);
					else doubleRightRotation(node);
				}
			}else{
				insert(newNode,node.right);
				
				int leftHeight = 0, rightHeight = 0;
				if(node.left != null) leftHeight = node.left.getHeight();
				if(node.right != null) rightHeight = node.right.getHeight();
				
				if((leftHeight - rightHeight) == 2){
					if(newNode.getEntry().keyGreaterThan(node.right.getEntry().getKey())) leftRotation(node);
					else doubleLeftRotation(node);
				}
			}
			node.updateHeight();
		}
	}
	
	public void remove(Comparable key){
		TreeNode node = get(key,this.root);
		if(node == null) throw new IllegalArgumentException("Chave não encontrada");
		
		
	}
	
	public TreeNode get(Comparable key){
		return get(key,this.root);
	}
	
	public TreeNode get(Comparable key, TreeNode node){
		if(node == null) return null;
		
		if(node.getEntry().keyEqual(key)) return node;
		else{
			if(node.getEntry().keyLowerThan(key)) return get(key,node.left);
			else return get(key,node.right);
		}
	}
	
//	public static void main(String[] args) {
//		AVLTree t = new AVLTree();
//		t.insert(new TreeNode(new AVLTreeEntry(2,10)));
//		t.insert(new TreeNode(5,2));
//		
//		TreeNode tn = t.get(5);
//		System.out.println(tn);
//	}
	
}
