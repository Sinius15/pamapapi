package com.sinius15.test;

import java.io.File;
import java.io.IOException;

import com.sinius15.pamapapi.Prison;
import com.sinius15.pamapapi.PrisonLoader;
import com.sinius15.pamapapi.PrisonSaver;

public class Test {

	public static void main(String[] args) throws IOException {
		Prison p = PrisonLoader.loadPrison(new File("C:\\Users\\Sijmen\\Desktop\\test.prison"));
		PrisonSaver.savePrison(p, new File("C:\\Users\\Sijmen\\Desktop\\testNew.prison"));
		
	}
	
}
