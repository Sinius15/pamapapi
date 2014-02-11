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
	
	public ArrayList<Entry> getEntrysByName(String name){
		ArrayList<Entry> out = new ArrayList<>();
		for(Entry e : this.entrys)
			if(e.name.equals(name))
				out.add(e);
		return out;
	}
	
	public ArrayList<DataBlock> getDataBlocksByName(String name){
		ArrayList<DataBlock> out = new ArrayList<>();
		for(DataBlock e : this.dataBlocks)
			if(e.name.equals(name))
				out.add(e);
		return out;
	}
	
	public void addEntry(String name, String value) {
		this.addEntry(new Entry(name, value));
	}
	
	public String toString(){
		return "DataBlock([name='"+name+"'])";
	}
	
}
