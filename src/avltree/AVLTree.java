package avltree;

public class AVLTree {
	private TreeNode root;
	
	public AVLTree(){
		
	}
	
	/**
	 * Faz a rotação pela esquerda na árvore.
	 * @param t Nó base da rotação.
	 */
	private void leftRotation(TreeNode t){
		TreeNode temp = t.right;
		t.right = t.right.left;
		temp.left = t;
		t = temp;
		
		t.left.updateHeight();
		t.updateHeight();
	}
	
	/**
	 * Faz a rotação pela direita na árvore.
	 * @param t Nó base da rotação.
	 */
	private void rightRotation(TreeNode t){
		TreeNode temp = t.left;
		t.left = t.left.right;
		temp.right = t;
		t = temp;
		
		t.right.updateHeight();
		t.updateHeight();
	}
	
	/**
	 * Faz a dupla rotação pela esquerda na árvore.
	 * @param t Nó base da rotação.
	 */
	private void doubleLeftRotation(TreeNode t){
		this.rightRotation(t.right);
		this.leftRotation(t);
	}
	
	/**
	 * Faz a dupla rotação pela direita na árvore.
	 * @param t Nó base da rotação.
	 */
	private void doubleRightRotation(TreeNode t){
		this.leftRotation(t.right);
		this.rightRotation(t);
	}
	
	/**
	 * Inserir na árvore.
	 * @param newNode Nó a ser inserido.
	 */
	public void insert(TreeNode newNode){
		insert(newNode,this.root);
	}
	
	/**
	 * Inserir na árvore passada como parâmetro.
	 * @param newNode Nó a ser inserido.
	 * @param node Nó base da inserção.
	 */
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
		
		System.out.println("Não implementado.");
	}
	
	/**
	 * Transposição da árvore (pré-ordem).
	 */
	public void transpor(){
		transpor(this.root);
	}
	
	/**
	 * Transposição da árvore.
	 * @param node Nó base da transposição (pré-ordem).
	 */
	public void transpor(TreeNode node){
		if(node == null) return;
		System.out.println(node.getKey());
		transpor(node.left);
		transpor(node.right);
	}
	
	/**
	 * Buscar um nó por sua chave.
	 * @param key Chave do nó a ser buscado.
	 * @return Nó buscado, ou, caso o mesmo não tenha sido encontrado, null.
	 */
	public TreeNode get(Comparable key){
		return get(key,this.root);
	}
	
	/**
	 * Buscar um nó por sua chave.
	 * @param key Chave do nó a ser buscado.
	 * @param node Nó base da busca.
	 * @return Nó buscado, ou, caso o mesmo não tenha sido encontrado, null.
	 */
	public TreeNode get(Comparable key, TreeNode node){
		if(node == null) return null;
		
		if(node.getEntry().keyEqual(key)) return node;
		else{
			if(node.getEntry().keyLowerThan(key)) return get(key,node.left);
			else return get(key,node.right);
		}
	}
}
