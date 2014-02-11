package aaed1;

public interface List {
	public ListEntry createListEntry(Object entryValue);
	public boolean listEmpty();
	public boolean listFull();
	public void clearList();
	public int listSize();
	public void insertList(Object entryValue, int position);
	public Object deleteList(int position);
	public void replaceList(Object entryValue, int position);
}
