import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SearchSpace {
	private int size;
	private String strings[];
	private int currentNumber;
	
	public SearchSpace() {
		fill();
		size = strings.length;
		currentNumber = 0;
	}
	
	public int getSize() { return size; }
	
	public String getNext() {
		String str = strings[currentNumber];
		currentNumber++;
		
		if(currentNumber >= size) { currentNumber = 0; }
		
		return str;
	}
	
	public void reset() { currentNumber = 0; }
	
	private void fill() {
		List<String> hashCodes = new ArrayList<String>();
		System.out.println("Reading in file...");
		
		URL url = getClass().getResource("/Words.txt");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
//            	if(!hashCodes.contains(line))
            		hashCodes.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        strings = new String[hashCodes.size()];
		int i = 0;
		for(String code : hashCodes) {
			strings[i++] = code;
		}
		System.out.println("Finished reading");		
	}
}
