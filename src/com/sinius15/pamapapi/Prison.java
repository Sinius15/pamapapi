package com.sinius15.pamapapi;

import java.io.File;
import java.util.ArrayList;

public class Prison {

	public String prisonName;
	public File sourceFile;
	public ArrayList<DataBlock> dataBlocks = new ArrayList<>();
	public ArrayList<Entry> entrys = new ArrayList<>();
	
	public void addDataBlock(DataBlock block){
		this.dataBlocks.add(block);
	}
	public void addEntry(Entry entry){
		this.entrys.add(entry);
	}
	public void addEntry(String name, String value){
		this.entrys.add(new Entry(name, value));
	}
	
}
