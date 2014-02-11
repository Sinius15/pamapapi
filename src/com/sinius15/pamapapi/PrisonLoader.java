package com.sinius15.pamapapi;

import java.io.File;

public class PrisonLoader {
	private static String syncLock = "teamMath";
	
	public static Prison loadPrison(File file){
		synchronized (syncLock) {
			Prison out = new Prison();
			out.sourceFile = file;
			out.prisonName = file.getName().replace(".prison", "");
			
			
			
			
			
			
		}
		return null;
	}
	
}
