package Hashes;

public class RotatingHash extends HashBase {

	public RotatingHash() {
		name = "Rotating hash";
	}
	
	@Override
	public int hash(int item) {
		return (item << 4) ^ (item >>> 28);
	}

}
