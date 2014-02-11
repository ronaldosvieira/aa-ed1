package aaed1;

public class DoublyLinkedListEntry extends ListEntry {
	private DoublyLinkedListEntry next;
	private DoublyLinkedListEntry prev;
	
	public DoublyLinkedListEntry(Object value, Object key){
		this(value);
		this.key = key;
	}
	
	public DoublyLinkedListEntry(Object value){
		this.value = value;
		this.next = null;
		this.prev = null;
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
}