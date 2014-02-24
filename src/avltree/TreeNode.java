package avltree;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	private AVLTreeEntry entry;
	private int height;
	
	/**
	 * Construtor do nó.
	 * @param entry Chave e valor do nó.
	 */
	public TreeNode(AVLTreeEntry entry){
		this.entry = entry;
		this.right = this.left = null;
		this.height = 0;
	}
	
	/**
	 * Construtor do nó.
	 * @param key	Chave do nó.
	 * @param value	Valor do nó.
	 */
	public TreeNode(Comparable key, Object value){
		this.entry = new AVLTreeEntry(key, value);
		this.right = this.left = null;
		this.height = 0;
	}
	
	/**
	 * Atualizar altura do nó.
	 */
	public void updateHeight(){
		int leftHeight = 0, rightHeight = 0;
		if(this.left != null) leftHeight = this.left.getHeight();
		if(this.right != null) rightHeight = this.right.getHeight();
		
		this.height = 1+Math.max(leftHeight,rightHeight);
	}

	/**
	 * Obter ponteiro para nó da esquerda.
	 * @return Nó filho esquerdo.
	 */
	public TreeNode getLeft() {
		return left;
	}

	/**
	 * Substituir ponteiro para nó da esquerda.
	 * @param left Nó filho esquerdo.
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	/**
	 * Obter ponteiro para nó da direita.
	 * @return Nó filho direito.
	 */
	public TreeNode getRight() {
		return right;
	}

	/**
	 * Substituir ponteiro para nó da direita.
	 * @param right Nó filho direito.
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}

	/**
	 * Obter a chave do nó.
	 * @return Chave do nó.
	 */
	public Comparable<Object> getKey(){
		return this.entry.getKey();
	}
	
	/**
	 * Obter o valor do nó.
	 * @return Valor do nó.
	 */
	public Object getValue(){
		return this.entry.getValue();
	}
	
	/**
	 * Obter valor e chave do nó.
	 * @return Objeto com valor e chave do nó.
	 */
	public AVLTreeEntry getEntry() {
		return this.entry;
	}

	/**
	 * Obter altura do nó.
	 * @return Altura do nó.
	 */
	public int getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.entry.getValue());
	}
}
