package com.sinius15.pamapapi;
/**
 * @website http://www.sinius15.com
 * @author Sinius15
 * @source http://github.com/Sinius15/pamapapi
 */
public class Entry {
	
	public String name, value;
	
	public Entry(String name, String value){
		this.name = name;
		this.value = value;
	}
	
	public String toString(){
		return "Entry([name='"+name+"'][value='"+value+"'])";
	}
	
}
