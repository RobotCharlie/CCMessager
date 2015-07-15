package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class testByteStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		

		FileInputStream fis =null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("/Users/CharlesGao/Documents/StartingPoint/proguard-project.txt");
			fos = new FileOutputStream("/Users/CharlesGao/Documents/proguard-project.txt");

			byte[] b = new byte[512];
			
			try {
				int n = 0;
				while ((n = fis.read(b)) != -1) {
					String s = new String(b, 0, n);
					System.out.println(s);
					fos.write(s.getBytes());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
