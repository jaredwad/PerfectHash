package Hashes;

public class JenkinsHash extends HashBase {

	public JenkinsHash() {
		name = "Jenkins hash";
	}
	
	@Override
	public int hash(int item) {
		item = (item + 0x7ed55d16) + (item <<  12);
		item = (item ^ 0xc761c23c) ^ (item >>> 19);
		item = (item + 0x165667b1) + (item <<  5 );
		item = (item + 0xd3a2646c) ^ (item <<  9 );
		item = (item + 0xfd7046c5) + (item <<  3 );
		item = (item ^ 0xb55a4f09) ^ (item >>> 16);
		   return item;
	}

}
