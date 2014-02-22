package list;

public interface List {
	/**
	 * Cria um novo nó.
	 * @param entryValue Valor do novo nó.
	 * @return Nó criado.
	 */
	public ListEntry createListEntry(Object entryValue);
	
	/**
	 * Verifica se a lista está vazia.
	 * @return True se a lista estiver vazia, caso contrário False.
	 */
	public boolean listEmpty();
	
	/**
	 * Verifica se a lista está cheia.
	 * @return True se a lista estiver cheia, caso contrário False.
	 */
	public boolean listFull();
	
	/**
	 * Deleta todos os nós da lista.
	 */
	public void clearList();
	
	/**
	 * Obtem o tamanho da lista.
	 * @return Tamanho da lista.
	 */
	public int listSize();
	
	/**
	 * Insere um novo nó na lista.
	 * @param entryValue Valor no nó a ser inserido.
	 * @param position Posição a ser inserido o nó.
	 */
	public void insertList(Object entryValue, int position);
	
	/**
	 * Deleta um nó da lista.
	 * @param position Posição do nó na lista.
	 * @return Nó deletado ou null caso o nó não exista.
	 */
	public Object deleteList(int position);
	
	/**
	 * Substitui um nó na lista.
	 * @param entryValue Valor do novo nó.
	 * @param position Posição do nó a ser substituido.
	 */
	public void replaceList(Object entryValue, int position);
}
