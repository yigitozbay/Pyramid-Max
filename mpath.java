import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.util.Arrays.stream;
public class mpath {
	public static int [][] pyramid; 
	public static ArrayList list=new ArrayList();
	
	public static int maxSum(int x,int y) throws IOException{			//sums the path
		if(x>=pyramid.length)
			return 0;
		int number=pyramid[x][y];
		if(isPrime(number)) {
			return 0;
		}
		else
			return number+Math.max(maxSum(x+1,y),maxSum(x+1,y+1));
	}
	public static void textFile () throws IOException {					//open txt file and adds into 2d array 
		int [][] txtFile=Files.lines(Paths.get("sample_input.txt")).map(s->stream(s.trim().split("\\s+"))
				.mapToInt(Integer::parseInt).toArray()).toArray(int [][]::new);
		pyramid=txtFile;
		System.out.println("MAX SUM OF NON PRIME PATH= "+maxSum(0,0));
	}
	
	
	public static boolean isPrime(int number) {					 //checks the number is prime or not 
		for(int i=2;i<number;i++) {
			if((number % i)==0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]) throws IOException{
		textfile();

	}
}












