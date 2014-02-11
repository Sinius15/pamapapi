package com.sinius15.pamapapi.test;

import java.io.File;
import java.io.IOException;

import com.sinius15.pamapapi.Prison;
import com.sinius15.pamapapi.PrisonLoader;

public class Test {

	public static void main(String[] args) throws IOException {
		Prison p = PrisonLoader.loadPrison(new File("C:\\Users\\Sijmen\\Desktop\\test.prison"));
		System.out.println(p);
		
	}
	
}
