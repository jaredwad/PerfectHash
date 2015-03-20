package Hashes;

public class LongHash extends HashBase {

	public LongHash() {
		name = "Long hash";
	}
	
	@Override
	public int hash(int item) {
		return mix(item & 0xC19A, item & 0x3E65, item);
	}

	private int mix(int a, int b, int c) {
		a = a - b;
		a = a - c;
		a = a ^ (c >>> 13);
		b = b - c;
		b = b - a;
		b = b ^ (a << 8);
		c = c - a;
		c = c - b;
		c = c ^ (b >>> 13);
		a = a - b;
		a = a - c;
		a = a ^ (c >>> 12);
		b = b - c;
		b = b - a;
		b = b ^ (a << 16);
		c = c - a;
		c = c - b;
		c = c ^ (b >>> 5);
		a = a - b;
		a = a - c;
		a = a ^ (c >>> 3);
		b = b - c;
		b = b - a;
		b = b ^ (a << 10);
		c = c - a;
		c = c - b;
		c = c ^ (b >>> 15);
		return c;

	}

}
