package com.sinius15.pamapapi;

import java.util.ArrayList;

public class DataBlock {

	public String name;
	public ArrayList<DataBlock> dataBlocks = new ArrayList<>();
	public ArrayList<Entry> entrys = new ArrayList<>();
	
	public DataBlock(String name){
		this.name = name;
	}
	
	public void addDataBlock(DataBlock block){
		this.dataBlocks.add(block);
	}
	public void addEntry(Entry entry){
		this.entrys.add(entry);
	}
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
	
}
