package Hashes;

public class KnuthHash extends HashBase {

	public KnuthHash() {
		name = "Knuth hash";
	}
	
	@Override
	public int hash(int item) {
		return (int) ((long)item * 2654435761l);
	}

}
