package com.lockedme.fileutils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.lockedme.com.LockedMeException;

/**
 *
 * @author ukumar
 *
 */
class LockedMeFilenameFilter implements FilenameFilter {

    String initials;

    public LockedMeFilenameFilter(String initials)
    {
        this.initials = initials;
    }
    public boolean accept(File dir, String name)
    {
        return name.startsWith(initials);

    }
}
/**
 * File Utilites class
 * @author ukumar
 *
 */
public class FileUtils {

	private String directory;


	public FileUtils(String directory) {
		super();
		this.directory = directory;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}


	/**
	 * Method to list the files in the directory
	 */
	public void RetrieveFilesInDir(){
		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();
		if(listOfFiles.length == 0) {
			System.out.println("The directory " + this.directory + "  is empty");
			return;
		}
		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    System.out.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
	}
	/**
	 * Method to delete file from a directory
	 * @param fileName
	 * @throws LockedMeException
	 */
	public void DeleteFileInDir(String fileName) throws LockedMeException {
		File file= new File(this.directory, fileName);
		if (file.delete()) {
			System.out.println("The file " + fileName + "  is deleted");
		}else {
			throw new LockedMeException("Failed to deleted file " +  fileName);
		}

	}
	/**
	 * Method to add file to a directory
	 * @param fileName
	 * @throws LockedMeException
	 */
	public void AddFileInDir(String fileName) throws LockedMeException {
		File file= new File(this.directory, fileName);
	    try {
	    	if(!file.createNewFile()) {
	    		System.out.println("File already exists");
	    	}
	    } catch (IOException e) {
	    	throw new LockedMeException("Failed to create " + fileName);
	    }

	}
	/**
	 * Method to search the file in a directory
	 * @param fileName
	 * @return
	 */
	public Boolean SearchFileInDir(String fileName) {
		LockedMeFilenameFilter filter
        = new LockedMeFilenameFilter(fileName);
		File dir = new File(this.directory);
		String[] fileList = dir.list(filter);
        if (fileList == null) {
            System.out.println("The directory is empty");
            return false;
        }
        else {
            for (int i = 0; i < fileList.length; i++) {
                System.out.println(fileList[i]+" found");
            }
           return true;
        }
	}
	/**
	 * Method to check if directory exists or not
	 * @param dir
	 * @return
	 */

	public static Boolean IsDirectoryExists(String dir) {
		Path path = Paths.get(dir);
		return Files.exists(path);

	}
}
