import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class MedianCal {
	
	private File files [] = null ;
	

	public void listFilesForFolder(String folder1) {
		File folder = new File(folder1);
		if (folder.isDirectory()) {
	          	files = folder.listFiles() ;
	          	Arrays.sort(files);
        } else {
            System.out.println("folder not found");
        }
    }
	
	public int countWords(String sentence){
		StringTokenizer st = new StringTokenizer(sentence);
		int counter = st.countTokens();
		return counter;
		
	}
/*
 * Input : List 
 * Output : Median of List
 * Desc: This method gives the median of a list depending on the list is even or odd.
 * 	
 */
	public double CalculateMedian(List list){
		double median = 0.0;
	
		Collections.sort(list);

		if (list.size() % 2 == 0){
			int x =	list.size()/2 ;
    
			median =  ((Integer)list.get(x) + (Integer)list.get(x - 1))/2.0;
		}
		else
		    median = (int) list.get(list.size()/2);
		return median;
	}
/* 
 * This Method reads multiple files from the folder wc_input and finds the count of 
 * each sentence in each file.
 * 	
 */
	public List readFile(File inputfiles[]) throws IOException{
		double median ;
		List list = new ArrayList();
		List list1 = new ArrayList();
		MedianCal cal= new MedianCal();
		String line ="";
		for (File inputfile :inputfiles)
		{
			FileReader infile = new FileReader(inputfile);
			BufferedReader br = new BufferedReader(infile);
				while((line=br.readLine()) != null){
					int count = cal.countWords(line);
					list.add(count);
			      
					if(list.size()==1){
						median =  ((Integer)list.get(0));
						}
					else 
					   median = cal.CalculateMedian(list);	
					System.out.println(median);
					list1.add(median);
				}
		}
				return list1;
		
		
	}
		
	public void Medianresult(List list, String outfile) throws IOException{
		
		Iterator iterator = list.iterator();
		File out_file = new File(outfile);
		BufferedWriter bw = new BufferedWriter(new FileWriter(out_file));
		while(iterator.hasNext())
		{
			bw.write(iterator.next().toString());
			bw.newLine();
		}
			bw.close();
		
	}
	
	/*
	 * Main Method
	 * 
	 */
	public static void main(String [] args) throws IOException{
		String line ="";
		double median ;
		List list = new ArrayList();
		MedianCal cal= new MedianCal();
		cal.listFilesForFolder(args[0]);
		List list1= cal.readFile(cal.files);
		cal.Medianresult(list1,args[1]);
	}
}