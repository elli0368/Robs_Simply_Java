package FileGet;

import java.io.File; // Import the File class
import java.util.Arrays;
import java.io.IOException; // Import the IOException class to handle errors

public class FileUtil {

	private String myFolder = "./myFiles/";

	public void addFile(String pFileName) {
		try {
			File directory = new File(myFolder);
			if (!directory.exists()) {
				directory.mkdir();
			}
			File myObj = new File(myFolder + pFileName);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred creating file");
			e.printStackTrace();
		}
	}

	public void deleteFile(String pFileName) {

		File myObj = new File(myFolder + pFileName);
		if (myObj.delete()) {
			System.out.println("Deleted the file: " + myObj.getName());
		} else {
			System.out.println("Failed to delete the file.");
		}
	}

	public void listFiles() {

		File folder = new File(myFolder);
		File[] files = folder.listFiles();

		Arrays.sort(files); // sort ascending

		if (files.length == 0) {
			System.out.println("No Files Found");
		} else {
			for (File file : files) {
				System.out.println(file.getName());
			}
		}
		System.out.println(""); // blank line
	}

	public void searchFile(String name) {
		boolean foundFile = false;
		File folder = new File(myFolder);
		File[] files = folder.listFiles();
		if (files != null)
			for (File fil : files) {
				if (name.equalsIgnoreCase(fil.getName())) {
					System.out.println("found file: " + fil.getName());
					foundFile = true;
				}
			}
		if (!foundFile) {
			System.out.println("file not found");
		}

	}
}
