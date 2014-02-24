package avltree;


public class AVLTreeEntry {
	private Object value;
	private Comparable<Object> key;
	
	/**
	 * Construtor do container do valor e da chave.
	 * @param key Chave do nó a ser guardada.
	 * @param value Valor do nó a ser guardado.
	 */
	public AVLTreeEntry(Comparable key, Object value) {
		this.value = value;
		this.key = key;
	}
	
	/**
	 * Verifica se chave do nó é menor do que chave passada como parâmetro.
	 * @param otherKey Chave a ser comparada.
	 * @return True se chave do nó for menor, caso contrário False.
	 */
	public boolean keyLowerThan(Comparable<Object> otherKey){
		return this.key.compareTo(otherKey) < 0;
	}
	
	/**
	 * Verifica se chave do nó é igual à chave passada como parâmetro.
	 * @param otherKey Chave a ser comparada.
	 * @return True se chave do nó for igual, caso contrário False.
	 */
	public boolean keyEqual(Comparable<Object> otherKey){
		return this.key.compareTo(otherKey) == 0;
	}
	
	/**
	 * Verifica se chave do nó é maior do que chave passada como parâmetro.
	 * @param otherKey Chave a ser comparada.
	 * @return True se chave do nó for maior, caso contrário False.
	 */
	public boolean keyGreaterThan(Comparable<Object> otherKey){
		return this.key.compareTo(otherKey) > 0;
	}
	
	/**
	 * Obter chave do nó.
	 * @return Chave do nó.
	 */
	public Comparable<Object> getKey() {
		return key;
	}
	
	/**
	 * Obter valor do nó.
	 * @return Valor do nó.
	 */
	public Object getValue() {
		return value;
	}
}
