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
		return "DataBlock([name='"+name+"'])" + System.lineSeparator() + "DataTree:" + System.lineSeparator() + toString(1, this);
	}
	public static String toString(int level, DataBlock f){
		String o = "";
		for(Entry e : f.entrys)
			o += "|" + getLevelString(level) + "-" + e + System.lineSeparator();
		for(DataBlock e : f.dataBlocks){
			o += "|" + getLevelString(level) + "" + e.name + System.lineSeparator();
			o += toString(level+1, e);
		}
			
		return o;
	}
	
	private static String getLevelString(int level){
		String o = "";
		for(int i = 0; i<level; i++){
			o+= "-|";
		}
		return o;
	}
}
