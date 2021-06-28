package com.lockedme.com;

import java.util.List;
import java.util.Scanner;

import com.lockedme.fileutils.FileUtils;

public class LockedMe {

	private static String DIRECTORY;

	public static String getDIRECTORY() {
		return DIRECTORY;
	}

	public static void setDIRECTORY(String dIRECTORY) {
		DIRECTORY = dIRECTORY;
	}

	public void DisplayOptions() {
		System.out.println("Please Select one of the following options");
		System.out.println("Options:");
		System.out.println("1) List the files directory");
		System.out.println("2) Add file in a directory");
		System.out.println("3) Delete file in a directory");
		System.out.println("4) Search file in a directory");
		System.out.println("5) Exit the LockedMe application");
	}

	public void DisplayAppDetails() {
		System.out.println("################################################################################");
		System.out.println("#################### Welcome to LockedMe Application ###########################");
		System.out.println("#################### Developed by Uday Kumar Ahirwal ###########################");
		System.out.println("################################################################################");
	}
	public static void main(String[] args) {

		LockedMe lockedMe = new LockedMe();
		Scanner userInput = new Scanner(System.in);
		lockedMe.DisplayAppDetails();
		String userDir;
		String fileName;
		do {
			System.out.println("Please enter the directory with path to be used.");
			userDir = userInput.nextLine();
			if(FileUtils.IsDirectoryExists(userDir)) {
				break;
			}
			System.out.println(userDir + " doesn't exists.");
		}while(true);

		FileUtils fileUtils = new FileUtils(userDir);

		do{

			lockedMe.DisplayOptions();
			int userOption = Integer.parseInt(userInput.nextLine());

			switch(userOption) {
			case 1:
				System.out.println("Listing the files in the directory.");
				fileUtils.RetrieveFilesInDir();
				break;
			case 2:
				System.out.println("Please enter a file name to be added.");
				while(!userInput.hasNext());
				fileName = userInput.nextLine();
				System.out.println(fileName);
				try {
					fileUtils.AddFileInDir(fileName);
				}catch(LockedMeException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Please enter a file name to be deleted.");
				while(!userInput.hasNext());
				fileName = userInput.nextLine();
				try {
					fileUtils.DeleteFileInDir(fileName);
				} catch (LockedMeException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Please enter a file name to be searched.");
				while(!userInput.hasNext());
				fileName = userInput.nextLine();
				fileUtils.SearchFileInDir(fileName);
				break;
			case 5:
				System.out.println("Exiting the LockedMe applciation.");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter the valid user option.");
			}
		}while(true);
	}





}
