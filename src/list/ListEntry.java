package list;

public class ListEntry {
	protected Object value;
	protected Object key;
	
	public ListEntry(Object value, Object key) {
		this.value = value;
		this.key = key;
	}
	
	public ListEntry(Object value){
		this.value = value;
	}
	
	public int compareTo(Object other){
		ListEntry l = (ListEntry) other;
		
		if(this.value == l.value) return 0;
		else return 1;
	}
	
	public Object getValue(){
		return this.value;
	}
	
	public Object getKey(){
		return this.key;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
