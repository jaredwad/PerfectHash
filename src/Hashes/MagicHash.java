package Hashes;

public class MagicHash extends HashBase {

	public MagicHash() {
		name = "Magic hash";
	}
	
	@Override
	public int hash(int item) {
		item = ((item >>> 16) ^ item) * 0x45d9f3b;
		item = ((item >>> 16) ^ item) * 0x45d9f3b;
		item = ((item >>> 16) ^ item);
	    return item;
	}

}
