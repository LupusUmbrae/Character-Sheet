package org.moss.charactersheet.actions.api;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * File filter to ensure conformity to *.sav format
 */
public class CustomFileFilter extends FileFilter {

	private static final String EXT = ".sav";

	/** Creates new CustomFilter that will conform to file extension *.sav*/
	public CustomFileFilter() {}
	
	@Override
	public boolean accept(File pathname) {
		if (pathname.isDirectory() || 
				pathname.getName().toLowerCase().endsWith(EXT)) {
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "*" + EXT;
	}
	
	public static String getFileExtension() {
		return EXT;
	}
}
