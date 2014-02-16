package com.sinius15.pamapapi;

import java.io.File;
/**
 * @website http://www.sinius15.com
 * @author Sinius15
 * @source http://github.com/Sinius15/pamapapi
 */
public class Prison extends DataBlock{

	public String prisonName;
	public File sourceFile;
	
	public Prison(String name) {
		super(name, "root");
		this.prisonName = name;
	}
	
	/**
	 * Seporator: ..
	 * @param path to the value
	 * @return the value found in the path
	 */
	public String getValue(String path){
		if(!path.contains("..")){
			Entry temp = getEntryByName(path);
			if(temp == null)
				return null;
			else
				return temp.value;
		}
			
		String[] split = path.split("\\.\\.");

		DataBlock block = getDataBlockByName(split[0]);
		if(block == null)
			return null;
		for(int i = 1; i<(split.length-1) ; i++){
			block = block.getDataBlockByName(split[i]);
			if(block == null)
				return null;
		}
		
		return block.getEntryByName(split[split.length-1]).value;
	}
	
	/**
	 * Seporator: ..
	 * @param path to the value
	 * @return the datablock found in the path
	 */
	public DataBlock getBlock(String path){
		if(!path.contains("..")){
			DataBlock temp = getDataBlockByName(path);
			if(temp == null)
				return null;
			else
				return temp;
		}
			
		String[] split = path.split("\\.\\.");

		DataBlock block = getDataBlockByName(split[0]);
		if(block == null)
			return null;
		for(int i = 1; i<(split.length) ; i++){
			block = block.getDataBlockByName(split[i]);
			if(block == null)
				return null;
		}
		return block;
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
