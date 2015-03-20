
public class PerfectHash {

	public static void main(String[] args) {
		Hash testHash = new Hash((int) Math.pow(2, 12));
		SearchSpace search = new SearchSpace();
		int size = search.getSize();
		
		for(int i = 0; i < size; ++i) {
			testHash.insert(search.getNext());
		}

//		testHash.printItems();
		testHash.printHash();
		
	}
	
	

}
