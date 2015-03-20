package Hashes;

public class SimpleHash extends HashBase{

	public SimpleHash() {
		name = "Simple hash";
	}
	
	@Override
	// This counts on using the indexFor method in hashSet ( item & size-1 )
	public int hash(int item) {
		return item; 
	}
}
