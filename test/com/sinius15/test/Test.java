package com.sinius15.test;

import java.io.File;
import java.io.IOException;

import com.sinius15.pamapapi.Prison;
import com.sinius15.pamapapi.PrisonLoader;
import com.sinius15.pamapapi.PrisonSaver;

/**
 * @website http://www.sinius15.com
 * @author Sinius15
 * @source http://github.com/Sinius15/pamapapi
 */

public class Test {

	public static void main(String[] args) throws IOException {
		Prison p = PrisonLoader.loadPrison(new File(System.getProperty("user.home") + "\\Desktop\\test.prison"));
		
		System.out.println(p.getValue("Thermometer..Temperature"));
		//p.getBlock("Thermometer").getEntryByName("Temperature").value = "12";
		
		
		PrisonSaver.savePrison(p, new File(System.getProperty("user.home") + "\\Desktop\\test_copy.prison"));
		
	}
	
}
