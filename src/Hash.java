
public class Hash {
	int size;
	HashSet array[];
	
	public Hash() { this((int) Math.pow(2, 19)); }
	
	public Hash(int startSize) {
		size = startSize;
		array = new HashSet[size];
		
	}
	
	public void insert(String item) {
		boolean inserted = false;
		int code = hash(item);
		
		if(array[code] == null)
			array[code] = new HashSet(); //Only initialize when needed to save space
		
		while (!inserted) {
			//Returns false if resized so keep trying
			//This saves space on heap (no recursion)
			inserted = array[code].insert(item); 
		}		
	}
	
	public void printHash() {
		int biggestSize = 0;
		int totalSize = 0;
		int mostItems = 0;
		int totalItems = 0;
		int numberEmpty = 0;
		double highestLoadFactor = 0.0;
		double lowestLoadFactor  = 1.0;
		
		for(int i = 0; i < size; ++i) {
			if(array[i] == null) {
				numberEmpty++;
				continue;
			}			
			int numItems = array[i].getNumItems();
			int size = array[i].getSize();
			
			totalItems += numItems;
			totalSize  += size;
			
			double loadFactor = (double) numItems / size;
			
			if(size > biggestSize  ) { biggestSize = size;     }
			if(numItems > mostItems) { mostItems   = numItems; }
			if(loadFactor > highestLoadFactor) { highestLoadFactor = loadFactor; }
			if(loadFactor < lowestLoadFactor ) { lowestLoadFactor  = loadFactor; }
			
			
			System.out.println("Set " + i + " has " + numItems
					+ " items and is size " + size + " on hash "
					+ array[i].getHash());
		}
		
		System.out.println();
		System.out.println("There were " + totalItems + " hashed into " + size + " buckets "
					+ "(A load factor of ~" + ((double) totalItems / size) + ")");
		System.out.println("Total size: " + totalSize);
		System.out.println("Biggest size: " + biggestSize);
		System.out.println("Most items: " + mostItems);
		System.out.println("Number empty: " + numberEmpty);
		System.out.println("Highest Load Factor: " + highestLoadFactor);
		System.out.println("Lowest  Load Factor: " + lowestLoadFactor );
	}
	
	public void printItems() {
		for(int i = 0; i < size; ++i) {
			if(array[i] == null)
				continue;
				
			System.out.println("Set " + i + " has " + array[i].getNumItems()
					+ " items and is size " + array[i].getSize() + " on hash "
					+ array[i].getHash());
			
			array[i].printItems();
		}
	}
	
	/*
	 * Hashes a string and retuns the index
	 */
	private int hash(String str) {
		return indexFor(hash(str.hashCode()));
	}
	
	/*
	 * Numbers were chosen by a run of the DFS for a hash
	 * sized 2^19 with 479829 words hashed (a dictionary)
	 */
	private int hash(int item) {
		item ^= (item >>> 8) ^ (item >>> 16);
		return item ^ (item >>> 14) ^ (item >>> 16);
	}
	
	/*
	 * Returns the index based on the size for an int
	 */
	private int indexFor(int h) {
	    return h & (size-1);
	}
	
}