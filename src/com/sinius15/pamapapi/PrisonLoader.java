package com.sinius15.pamapapi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * @website http://www.sinius15.com
 * @author Sinius15
 * @source http://github.com/Sinius15/pamapapi
 */
public class PrisonLoader {
	private static String syncLock = "teamMathB";
	
	public static Prison loadPrison(File file) throws IOException{
		if(!file.exists())
			throw new FileNotFoundException("[sqrerror] File Not Found: "+file.getAbsolutePath());
		synchronized (syncLock) {
			
			Prison out = new Prison(file.getName().replace(".prison", ""));
			out.sourceFile = file;
			
			BufferedReader br;
			int numberOfLines;
			String[] lines, split;
			String line;
			int i;
			
			numberOfLines = countLines(file);
			lines = new String[numberOfLines+1];
			
			br = new BufferedReader(new FileReader(file));
			i = 0;
			while ((line = br.readLine()) != null) {
				lines[i] = line;
				i++;
			}
			br.close();
			for(i = 0; i < lines.length ; i++){
				line = lines[i];
				if(line == null)
					continue;
				if(line.startsWith("BEGIN")){
					if(line.endsWith("END"))
						out.addDataBlock(createSinglelineDataBlock(line, ""));
					else
						out.addDataBlock(createMultilineDataBlock(lines, i, "").a);
				}else if(line.startsWith(" ") || line.startsWith("END")){
					continue;
				}else{
					if(!line.contains(" "))
						continue;
					line = line.replaceAll("\\s+", " ");
					split = line.split(" ");
					out.addEntry(split[0], split[1]);
				}
			}
			return out;
		}
		
	}
	/**
	 * @author Sinius15
	 * @param fileIn
	 * @param lineNumberBEGIN = the line where the DataBlock starts
	 * @param level: the parent level where the datablock is in.
	 * @return the <b>DataBlock</b> that started on the line given
	 */
	private static Pair<DataBlock, Integer> createMultilineDataBlock(String[] fileIn, int lineNumberBEGIN, String level){
		//finding the name of the current block;
		String beginLine = fileIn[lineNumberBEGIN].trim();
		String[] split = beginLine.split(" ");
		String name = split[1];
		if(name.startsWith("\""))
			name = split[1]+ " " + split[2];
		DataBlock out = new DataBlock(name, level + ".." + name);
		
		//filling the current block with data
		int i = lineNumberBEGIN+1;
		while(!fileIn[i].startsWith("END")){
			String line = fileIn[i];
			if(line == null)
				continue;
			
			line = line.trim();
			if(line.startsWith("BEGIN")){
				if(line.endsWith("END")){
					out.addDataBlock(createSinglelineDataBlock(line, level + ".." + out.name));
					i++;
				}
				else{
					Pair<DataBlock, Integer> t = createMultilineDataBlock(fileIn, i, level + ".." + out.name);
					out.addDataBlock(t.a);
					i+=t.b;
				}
					
			}else if(line.startsWith("END")){
				break;
			}else{
				if(!line.contains(" "))
					continue;
				line = line.replaceAll("\\s+", " ");
				split = line.split(" ");
				out.addEntry(split[0], split[1]);
				i++;
			}
		}
		return new Pair<DataBlock, Integer>(out, i-lineNumberBEGIN+1);
	}
	
	/**
	 * 
	 * @author Sinius15
	 * @param fileIn
	 * @param lineNumberBEGIN = the line where the DataBlock starts
	 * @param level: the parent level where the datablock is in.
	 * @return the <b>DataBlock</b> that started on the line given
	 */
	private static DataBlock createSinglelineDataBlock(String line, String level){
		int i = 2;
		String builder = line;
		builder.trim();
		line = line.replaceAll("\\s+", " ");
		String[] split = line.split(" ");
		String name = split[1];
		if(name.startsWith("\"")){
			name = split[1] + " " +split[2];
			i++;
		}
		
		DataBlock out = new DataBlock(name, level + ".." + name);
		
		for(; i<split.length; i+=2){
			if(split[i].equals("END"))
				continue;
			out.addEntry(new Entry(split[i], split[i+1]));
		}
		return out;
	}
	
	/**
	 * 
	 * @author http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
	 * @param file
	 * @return the amount of lines in a file
	 * @throws IOException
	 */
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
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
	
}




























