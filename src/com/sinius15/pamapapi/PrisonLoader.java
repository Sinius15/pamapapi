package com.sinius15.pamapapi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class PrisonLoader {
	private static String syncLock = "teamMath";
	
	public static Prison loadPrison(File file) throws IOException{
		if(!file.exists())
			throw new FileNotFoundException("[sqrerror] File Not Found: "+file.getAbsolutePath());
		synchronized (syncLock) {
			
			Prison out = new Prison();
			BufferedReader br;
			int numberOfLines;
			String[] lines;
			String line;
			int i;
			
			
			
			out.sourceFile = file;
			out.prisonName = file.getName().replace(".prison", "");
			
			System.out.println("reading file...");
			numberOfLines = countLines(file);
			System.out.println("Number of Lines in the file: " + numberOfLines);
			lines = new String[numberOfLines+1];
			
			br = new BufferedReader(new FileReader(file));
			i = 0;
			while ((line = br.readLine()) != null) {
				lines[i] = line;
				i++;
			}
			br.close();
			System.out.println("reading done! ");
			
			
			
			return out;
		}
		
	}
	
	/**
	 * 
	 * @author http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
	 * @param file
	 * @return the amount of lines in a file
	 * @throws IOException
	 */
	private static int countLines(File file) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(file));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    count++;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
	
}
