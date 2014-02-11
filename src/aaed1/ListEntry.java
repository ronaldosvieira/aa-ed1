package aaed1;

public class ListEntry {
	protected Object value;
	protected Object key;
	
	public int compareTo(Object other){
		ListEntry l = (ListEntry) other;
		// TODO: Como comparar ListEntrys?
		
		if(this.value == l.value) return 0;
		else return 1;
	}
	
	public Object getValue(){
		return this.value;
	}
	
	public Object getKey(){
		return this.key;
	}
	
}
