package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class testCharacterStreamBufferedReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
		BufferedWriter bw = null;
	
		FileReader fr;
		FileWriter fw;
		try {
			fr = new FileReader("/Users/CharlesGao/Documents/StartingPoint/proguard-project.txt");
			fw = new FileWriter("/Users/CharlesGao/Documents/proguard-project.txt");
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			String s;  //So important, must use String s, or the .txt could not display completely.
			while((s=br.readLine()) !=null){
				
				bw.write(s+"\r\n");
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
