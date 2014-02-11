package com.sinius15.pamapapi;

import java.io.File;
import java.util.ArrayList;

public class Prison {

	public String prisonName;
	public File sourceFile;
	public ArrayList<DataBlock> dataBlocks = new ArrayList<>();
	public ArrayList<Entry> entrys = new ArrayList<>();
	
	public Entry getEntryByName(String name){
		for(Entry out : this.entrys)
			if(out.name.equals(name))
				return out;
		return null;
	}
	public DataBlock getDataBlockByName(String name){
		for(DataBlock out : this.dataBlocks)
			if(out.name.equals(name))
				return out;
		return null;
	}
	public void addDataBlock(DataBlock block){
		this.dataBlocks.add(block);
	}
	public void addEntry(Entry entry){
		this.entrys.add(entry);
	}
	public void addEntry(String name, String value){
		this.entrys.add(new Entry(name, value));
	}
	
	public String toString(){
		String o = "Prison[(name='')(sourceFile='')(dataBlocksAmount='')(entryAmount='')"+System.lineSeparator();
		o += "DataTree:" + System.lineSeparator();
		for(Entry e : entrys){
			o += "|-'" + e.name + "':'" + e.value + ";" + System.lineSeparator();
		}
		
		return o;
	}
	
	public String DataBlockToString(int level){
		String o = "";
		for(Entry e : entrys){
			o += "|-"
		}
	}
	
	public String getLevelString(int level){
		String o = "";
		for(int i = 0; i<level; i++){
			
		}
	}
	
}
