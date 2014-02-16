package com.sinius15.pamapapi;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * @website http://www.sinius15.com
 * @author Sinius15
 * @source http://github.com/Sinius15/pamapapi
 */
public class PrisonSaver {

	private static String syncLock = "teamMathA";
	
	public static void savePrison(Prison in, File file) throws IOException{
		ArrayList<String> out = new ArrayList<>();
		out.add("");
		synchronized (syncLock) {
			for(Entry e : in.entrys)
				out.add(EntryToSingleLineString(e));
			for(DataBlock b : in.dataBlocks)
				if(b.dataBlocks.size() == 0 && b.entrys.size() < 13)
					out.add(DataBlockToSingleLine(b));
				else
					out.addAll(DataBlockToMuliBlock(b, 0));
		}
		PrintWriter writer = new PrintWriter(file, "UTF-8");
		for(String s : out)
			writer.println(s);
		writer.close();
	}
	
	
	private static ArrayList<String> DataBlockToMuliBlock(DataBlock in, int level){
		
		ArrayList<String> b = new ArrayList<>();
		
		b.add("BEGIN "+in.name + "   ");
		for(Entry e : in.entrys)
			b.add(spaceString(4) + EntryToSingleLineString(e) + "  ");
		for(DataBlock e : in.dataBlocks)
			if(e.dataBlocks.size() == 0 && e.entrys.size() < 13)
				b.add(spaceString(4) + DataBlockToSingleLine(e));
			else
				b.addAll(DataBlockToMuliBlock(e, level+1));
		b.add("END");
		for(int i = 0; i < b.size() ; i++){
			b.set(i, spaceString(4*level) + b.get(i));
		}
			
		
		return b;
	}
	/**
	 *  BEGIN_name_?_entry__entry__entry__entry__END
	 */
	private static String DataBlockToSingleLine(DataBlock in){
		String b = "BEGIN "+in.name+spaceString(12-in.name.length()) + " ";
		for(Entry e : in.entrys)
			b +=EntryToInlineString(e) + "  ";
		b+= "END";
		return b;
	}
	/**
	 *  name_value
	 */
	private static String EntryToInlineString(Entry in){
		return in.name + " " + in.value;
	}
	/**
	 *  name_?_value
	 */
	private static String EntryToSingleLineString(Entry in){
		return in.name + spaceString(20-in.name.length()+1) + in.value;
	}
	/**
	 * a string of spaces. amount of spaces is the lenght.
	 */
	private static String spaceString(int leng){
		String o = "";
		for(int i = 0; i<leng; i++)
			o += " ";
		return o;
	}
}
