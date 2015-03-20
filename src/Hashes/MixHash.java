package Hashes;

public class MixHash extends HashBase {

	public MixHash() {
		name = "Mix hash";
	}
	
	@Override
	public int hash(int item) {
		item = ~item + (item << 15); // key = (key << 15) - key - 1;
		item = item ^ (item >>> 12);
		item = item + (item << 2);
		item = item ^ (item >>> 4);
		item = item * 2057; // key = (key + (key << 3)) + (key << 11);
		item = item ^ (item >>> 16);
		  return item;
	}

}
