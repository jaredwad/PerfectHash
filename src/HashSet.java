import java.util.ArrayList;
import java.util.List;
import Hashes.*;

public class HashSet {
	static List<HashBase> list;
	static boolean isInitialized = false;
	static final double LoadFactor = 1;
	String hashTable[];
	int size;
	int numItems;
	int currentHash;
	
	public HashSet() { this(1); }
	
	public HashSet(int pSize) {
		initialize();
		hashTable = new String[pSize];
		size = pSize;
		numItems = 0;
		currentHash = 0;
	}
	
	public int getSize    () { return size;        }
	public int getNumItems() { return numItems;    }
	public String getHash () { return list.get(currentHash).getName(); }
	
	public Boolean insert(String item) {
		int code = hash(item);
//		System.out.println("insterting \"" + item + "\" with code " + code);
		
		
		if(hashTable[code] == null) {
			hashTable[code] = item;
			numItems++;
			return true;
		} else {
			if(item.equals(hashTable[code])) { return true; } //No duplicates!!!
			reorganizeTable();
//			insert(item);
			return false;
		}
	}
	
	public String get(String item) {
		String var = hashTable[hash(item)];
		
		//Its strings now, but this can be applied to other things
		if(var == item) { return var; } 
		
		return null;
	}
	
	public void printItems() {
		int index = 0;
		for(int i = 0; i < size; ++i) {
			if(hashTable[i] != null) {
				System.out.println("Item " + index + " (index " + i + ") is: " + hashTable[i]);
				index++;
			}
		}
	}
	
	private void initialize() {
		if(isInitialized == true) {
			return;
		}
		isInitialized = true;
		list = new ArrayList<HashBase>();
		
		list.add(new SimpleHash  ());
		list.add(new KnuthHash   ());
		list.add(new RotatingHash());
		list.add(new MagicHash   ());
		list.add(new MurMurHash  ());
		list.add(new MixHash     ());
		list.add(new JenkinsHash ());
		list.add(new LongHash    ());
	}
	
	private void reorganizeTable() {
		if(((double)numItems / size) > LoadFactor) {
			resize();
		} else {
			changeHash();
		}
	}
	
	private void resize() {
		size *= 2;
		TempRehash();
//		rehash();
	}
	
	private void changeHash() {
		currentHash++;
		if(currentHash >= list.size()) {
			currentHash = 0;
			resize();
		} else {
			TempRehash();
//			rehash();
		}
	}
	
	//Recursive rehash (very bad, DO NOT USE. cool concept though it just
	//eats up memory like there's no tomorrow
	private String[] rehash() {
		String[] oldValues = hashTable;
		hashTable = new String[size];
		int len = oldValues.length;
		int items = 0;
		
		for(int i = 0; i < len; ++i) {
			if(oldValues[i] != null) {
				insert(oldValues[i]);
				items++;
			}
		}
		numItems = items;
		return oldValues;
	}
	
	private void TempRehash() {
		String[] oldValues = hashTable;
		int len = oldValues.length;
		
		while(true) {
			hashTable = new String[size];
			int i = 0;
			for(; i < len; ++i) {
				if(oldValues[i] != null) {
					if (secondInsert(oldValues[i]) == false) {
						break;
					}
				}
			}
			if(i == len)
				break; //Rehashing worked

			currentHash++;
			if(currentHash >= list.size()) {
				currentHash = 0;
				size *= 2;
			}
		}
	}
	
	//Used to not make inserting recursive (again save memory)
	private boolean secondInsert(String item) {
		int code = hash(item);
		
		if(hashTable[code] == null) {
			hashTable[code] = item;
			return true;
		} else {
			if(item.equals(hashTable[code])) { return true; } //No duplicates!!!
			return false;
		}
	}
	
	private int hash(String item) {
		return indexFor(list.get(currentHash).hash(item));
	}
	
	/**
	 * Returns index for hash code h.
	 */
	private int indexFor(int h) {
	    return h & (size-1);
	}
}