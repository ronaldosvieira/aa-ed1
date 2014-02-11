package aaed1;

public class DoublyLinkedList implements List{
	private DoublyLinkedListEntry inicio;
	private int size;
	private int maxSize;
	
	// Construtor sem especificar tamanho máximo
	public DoublyLinkedList(){
		this.inicio = null;
		this.size = 0;
		this.maxSize = -1;
	}
	//
	
	// Construtor especificando um tamanho máximo
	public DoublyLinkedList(int maxSize){
		this();
		if(maxSize > 0) this.maxSize = maxSize;
		else throw new IllegalArgumentException("MaxSize must be greater than zero.");
	}
	//
	
	// Criar um novo nó
	@Override
	public ListEntry createListEntry(Object entryValue) {
		return new DoublyLinkedListEntry(entryValue);
	}
	//
	
	// Verificar se a lista está vazia
	@Override
	public boolean listEmpty() {
		//return (this.size == 0);
		return (this.inicio == null);
	}
	//

	// Verificar se a lista está cheia (se foi especificado um tam máx)
	@Override
	public boolean listFull() {
		return ((this.maxSize != -1)&&(this.size == this.maxSize));
	}

	@Override
	public void clearList() {
		this.inicio = null;
		this.size = 0;
		// TODO: Deletar os nós da memória?
	}

	@Override
	public int listSize() {
		return this.size;
	}

	@Override
	public void insertList(Object entryValue, int position) {
		// Procura o nó na posicao indicada
		DoublyLinkedListEntry temp = this.getNode(position);
		
		// Cria um novo nó
		DoublyLinkedListEntry newNode = (DoublyLinkedListEntry) createListEntry(entryValue);
		
		// Ajeita os "ponteiros"
		// TODO: Consertar inserção no final da lista
		newNode.setPrev(temp.getPrev());
		newNode.setNext(temp);
		temp.setPrev(newNode);
		temp.getPrev().setNext(newNode);
		
		this.size++;
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
	
	// Procura um nó pela posição
	public DoublyLinkedListEntry getNode(int position){
		DoublyLinkedListEntry it = this.inicio;
		
		if(position > this.size) throw new IllegalArgumentException("Non-existent position.");
		else if(position == this.size) return null;
		
		for(int i=0; i < position; i++) it = it.getNext();
		
		return it;
	}
	//
	
	@Override
	public void replaceList(Object entryValue, int position) {
		if(position == this.size) throw new IllegalArgumentException("Null position");
		
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
	
	public DoublyLinkedListEntry setPosition(int position){
		// TODO: O que fazer aqui?
		return null;
	}
	
	public static void main(String[] args) {
		 DoublyLinkedList lista = new DoublyLinkedList(4);
		 lista.insertList(10, 0);
		 lista.insertList(5, 1);
		 lista.insertList(3, 2);
		 lista.insertList(9, 4);
		 lista.insertList(7, 5);
	}

}
