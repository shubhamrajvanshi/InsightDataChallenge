
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordCount {
	private File files [] = null ;
	
	private HashMap<String, Integer> wordcount = new HashMap<String, Integer>();
	
	public void listFilesForFolder(String path) {
		File folder = new File(path);
		if (folder.isDirectory()) {
	        	files = folder.listFiles() ;
	        } else {
	            System.out.println("folder not found");
	        }
	    }
	
	public void countwords(File inputfiles[]) throws IOException{
		String line = "";
		for (File inputfile :inputfiles)
		{
		FileReader infile = new FileReader(inputfile);
		BufferedReader br = new BufferedReader(infile);
			while((line=br.readLine()) != null){
		//		System.out.println(line);
		// So that punctuation is 		
				String words[] = line.replaceAll("[^a-zA-Z@ ]", "").toLowerCase().split(" ");
				for(String word : words){
					if(wordcount.containsKey(word))
					{
						wordcount.put(word, wordcount.get(word)+1);
					}
					else
					{
						wordcount.put(word, 1);
					}
				}
				
			}
			br.close();
			
		}
		 for (String key : wordcount.keySet()) {
		        System.out.println(key + " " + wordcount.get(key));
		    }
	}
	
	public void wordcountresult(String outpath) throws IOException{
		TreeMap<String,Integer> tm = new TreeMap<String, Integer>(wordcount);
		Set  set = tm.entrySet();
		Iterator iterator = set.iterator();
		File out_file = new File(outpath);
		BufferedWriter bw = new BufferedWriter(new FileWriter(out_file));
		while(iterator.hasNext())
		{
			Map.Entry me = (Map.Entry) iterator.next();
			bw.write(me.getKey() + " " + me.getValue());
			bw.newLine();
		}
			bw.close();
		
	}
	
	public static void main(String args[]) throws IOException
	{
		WordCount w = new WordCount();
		w.listFilesForFolder(args[0]);
		w.countwords(w.files);
		w.wordcountresult(args[1]);
	}
}
