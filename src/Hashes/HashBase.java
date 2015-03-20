package Hashes;

public abstract class HashBase {
//	protected int size;
	protected String name;
	
	public int hash(String item) {
		return this.hash(item.hashCode());
	}
	public abstract int hash(int item);
	
	public String getName() {
		return name;
	}
}
