package com.sinius15.pamapapi;

import java.io.File;

public class Prison extends DataBlock{

	public String prisonName;
	public File sourceFile;
	
	public Prison(String name) {
		super(name);
		this.prisonName = name;
	}

	public String toString(){
		String o = "Prison[(name='')(sourceFile='')(dataBlocksAmount='')(entryAmount='')"+System.lineSeparator();
		o += "DataTree:" + System.lineSeparator();
		for(Entry e : entrys){
			o += "|-'" + e.name + "':'" + e.value + ";" + System.lineSeparator();
		}
		for(DataBlock e : dataBlocks){
			o += "" + e.name + System.lineSeparator();
			o += toString(1, e);
		}
		
		return o;
	}
	

	
}
