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
		Prison p = PrisonLoader.loadPrison(new File(System.getProperty("user.home") + "\\Desktop\\test17.prison"));
		PrisonSaver.savePrison(p, new File(System.getProperty("user.home") + "\\Desktop\\test17_new.prison"));
		
	}
	
}
