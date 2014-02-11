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
			out.sourceFile = file;
			out.prisonName = file.getName().replace(".prison", "");
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			System.out.println(countLines(file));
			String line;
			while ((line = br.readLine()) != null) {
				
			}
			br.close();
			
			
			
			
			return out;
		}
		
	}
	
	public static int countLines(File file) throws IOException {
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
	        return (count == 0 && !empty) ? 1 : count+1;
	    } finally {
	        is.close();
	    }
	}
	
}
