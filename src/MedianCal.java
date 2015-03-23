import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class MedianCal {
	
	private File files [] = null ;
	static File folder = new File("./wc_input");

	public void listFilesForFolder(File folder) {
	        if (folder.isDirectory()) {
        	files = folder.listFiles() ;
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
	public void readFile(File inputfiles[]) throws IOException{
		String line ="";
		for (File inputfile :inputfiles)
		{
			FileReader infile = new FileReader(inputfile);
			BufferedReader br = new BufferedReader(infile);
				while((line=br.readLine()) != null){
					System.out.println(line);
				}
		}
	}
		
	
	public static void main(String [] args) throws IOException{
		String line ="";
		double median ;
		List list = new ArrayList();
		//int[] numArray = new int[6];
	
	
		MedianCal cal= new MedianCal();
		cal.listFilesForFolder(cal.folder);
		cal.readFile(cal.files);
		
		int count = cal.countWords(line);
		System.out.println("Your sentence count is  : "+ count);

		list.add(count);
      
		if(list.size()==1){
			median =  ((Integer)list.get(0));
			}else 
		   median = cal.CalculateMedian(list);	
			System.out.println("Median :" +median);
		
	}
}