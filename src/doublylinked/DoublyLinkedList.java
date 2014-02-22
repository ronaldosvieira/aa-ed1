package doublylinked;

import list.List;
import list.ListEntry;

public class DoublyLinkedList implements List{
	private DoublyLinkedListEntry inicio;
	private int size;
	private int maxSize;
	
	/**
	 * Construtor com tamanho máximo não especificado.
	 */
	public DoublyLinkedList(){
		this.inicio = null;
		this.size = 0;
		this.maxSize = -1;
	}
	
	/**
	 * Construtor com tamanho máximo especificado.
	 * @param maxSize Tamanho máximo da lista.
	 */
	public DoublyLinkedList(int maxSize){
		this();
		if(maxSize > 0) this.maxSize = maxSize;
		else throw new IllegalArgumentException("Tamanho máximo tem que ser maior que zero.");
	}
	
	@Override
	public ListEntry createListEntry(Object entryValue) {
		return new DoublyLinkedListEntry(entryValue);
	}
	
	@Override
	public boolean listEmpty() {
		return (this.size == 0);
	}

	@Override
	public boolean listFull() {
		return ((this.maxSize != -1)&&(this.size == this.maxSize));
	}

	@Override
	public void clearList() {
		this.inicio = null;
		this.size = 0;
	}

	@Override
	public int listSize() {
		return this.size;
	}

	@Override
	public void insertList(Object entryValue, int position) {		
		// Cria um novo nó
		DoublyLinkedListEntry newNode = (DoublyLinkedListEntry) createListEntry(entryValue);
		
		// Ajeita os "ponteiros"
		if(this.listEmpty()) this.inicio = newNode;
		else {
			DoublyLinkedListEntry ant = this.getNode(position-1);
			DoublyLinkedListEntry post = this.getNode(position);
			
			if(ant != null){
				ant.setNext(newNode);
				newNode.setPrev(ant);
			}
			if(post != null){
				post.setPrev(newNode);
				newNode.setNext(post);
			}
		}
		
		
		this.size++;
	}
	
	public void insertList(Object entryValue){
		this.insertList(entryValue, this.listSize());
	}
	
	@Override
	public Object deleteList(int position) {
		// Procura nó a ser deletado
		DoublyLinkedListEntry deletedNode = this.getNode(position);
		
		// Ajeita os "ponteiros"
		deletedNode.getPrev().setNext(deletedNode.getNext());
		deletedNode.getNext().setPrev(deletedNode.getPrev());
		
		this.size--;
		
		return deletedNode;
	}
	
	/**
	 * Obter uma determinada posição da lista.
	 * @param position Posição do nó a ser buscado.
	 * @return Nó da posição requerida.
	 */
	public DoublyLinkedListEntry getNode(int position){
		DoublyLinkedListEntry it = this.inicio;
		
		if(position >= this.size) return null;
		
		for(int i=0; i < position; i++) it = it.getNext();
		
		return it;
	}
	
	@Override
	public void replaceList(Object entryValue, int position) {
		if(position == this.size) throw new IllegalArgumentException("Posição não existente.");
		
		//Procura o nó a ser substituido
		DoublyLinkedListEntry replacedNode = this.getNode(position);
		
		// Cria um novo nó
		DoublyLinkedListEntry newNode = (DoublyLinkedListEntry) createListEntry(entryValue);
		
		// Ajeita os "ponteiros"
		newNode.setPrev(replacedNode.getPrev());
		newNode.setNext(replacedNode.getNext());
		replacedNode.getPrev().setNext(newNode);
		replacedNode.getNext().setPrev(newNode);
	}
	
	/**
	 * Obter nó da posição especificada.
	 * @param position Posição do nó a ser buscado.
	 * @return Nó na posição especificada.
	 */
	public DoublyLinkedListEntry getPosition(int position){
		return this.getNode(position);
	}
	
	@Override
	public String toString() {
		String s = "[ ";
		DoublyLinkedListEntry temp = this.inicio;
		while(temp != null){
			s += temp.toString() +" ";
			temp = temp.getNext();
		}
		s += "]";
		return s;
	}
}
