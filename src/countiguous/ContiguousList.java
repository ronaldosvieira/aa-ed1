package countiguous;

import list.List;
import list.ListEntry;

public class ContiguousList implements List {
	ListEntry[] list;
	private int size;
	private int maxSize;
	
	public ContiguousList(int maxSize){
		this.size = 0;
		if(maxSize > 0) this.maxSize = maxSize;
		else throw new IllegalArgumentException("Tamanho máximo tem que ser maior que zero.");
		this.list = new ListEntry[maxSize];
	}

	@Override
	public ListEntry createListEntry(Object entryValue) {
		return new ListEntry(entryValue);
	}

	@Override
	public boolean listEmpty() {
		return (this.size == 0);
	}

	@Override
	public boolean listFull() {
		return (this.size == this.maxSize);
	}

	@Override
	public void clearList() {
		this.size = 0;
		list = new ListEntry[maxSize];
	}

	@Override
	public int listSize() {
		return this.size;
	}

	@Override
	public void insertList(Object entryValue, int position) {
		position %= maxSize;
		if(this.listFull()) throw new IllegalArgumentException("Lista cheia");
		
		if(this.list[position] != null)	{
			for (int i = this.listSize(); i > position; i--) {
				this.list[i] = this.list[i-1];
			}
		}
		
		this.list[position] = this.createListEntry(entryValue);
		this.size++;
	}
	
	public void insertList(Object entryValue){
		this.insertList(entryValue,this.listSize());
	}

	@Override
	public Object deleteList(int position) {
		position %= maxSize;
		if(this.list[position] == null) throw new IllegalArgumentException("Posição não existente");

		Object deletedNode = this.list[position];
		for (int i = position; i < this.listSize(); i++) {
			this.list[position] = this.list[position+1];
		}
		
		this.size--;
		return deletedNode;
	}

	@Override
	public void replaceList(Object entryValue, int position) {
		position %= maxSize;
		if(this.list[position] == null) throw new IllegalArgumentException("Posição não existente");
		
		this.list[position] = createListEntry(entryValue);
	}
}
