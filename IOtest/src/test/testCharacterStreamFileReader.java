package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class testCharacterStreamFileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null;
		FileWriter fw = null; 
		int n = 0;
		try {
			fr = new FileReader("/Users/CharlesGao/Documents/StartingPoint/proguard-project.txt");
			fw = new FileWriter("/Users/CharlesGao/Documents/proguard-project.txt");
			
			char c[] = new char[1024];
			
			while((n = fr.read(c))!=-1){
				
				fw.write(c,0,n);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}

}
