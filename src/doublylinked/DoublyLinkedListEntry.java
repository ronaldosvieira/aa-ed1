package doublylinked;

import list.ListEntry;

public class DoublyLinkedListEntry extends ListEntry {
	private DoublyLinkedListEntry next;
	private DoublyLinkedListEntry prev;
	
	public DoublyLinkedListEntry(Object value) {
		super(value);
	}

	public DoublyLinkedListEntry(Object value, Object key) {
		super(value,key);
	}
	
	public void setNext(DoublyLinkedListEntry next){
		this.next = next;
	}
	
	public DoublyLinkedListEntry getNext(){
		return this.next;
	}
	
	public void setPrev(DoublyLinkedListEntry prev){
		this.prev = prev;
	}
	
	public DoublyLinkedListEntry getPrev(){
		return this.prev;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}