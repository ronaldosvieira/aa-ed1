package avltree;


public class AVLTreeEntry {
	private Object value;
	private Comparable<Object> key;
	
	public AVLTreeEntry(Comparable key, Object value) {
		this.value = value;
		this.key = key;
	}
	
	public boolean keyLowerThan(Comparable<Object> otherKey){
		return this.key.compareTo(otherKey) < 0;
	}
	
	public boolean keyEqual(Comparable<Object> otherKey){
		return this.key.compareTo(otherKey) == 0;
	}
	
	public boolean keyGreaterThan(Comparable<Object> otherKey){
		return this.key.compareTo(otherKey) > 0;
	}
	
	public Comparable<Object> getKey() {
		return key;
	}
	
	public Object getValue() {
		return value;
	}
}
