package Hashes;

public class MurMurHash extends HashBase {

	public MurMurHash() {
		name = "MurMur hash";
	}
	
	@Override
	public int hash(int item) {
		item ^= item >>> 33;
		item *= 0x85ebca6b;
		item ^= item >>> 33;
		item *= 0xc2b2ae35;
		item ^= item >>> 33;
		return item;
	}

}
