package FileGet;

import java.util.Scanner;

public class FileGetMain {

	// private static char verbose = 'Y'; // verbose mode
	private static char verbose = 'N'; // non-verbose mode

	public static void print_debug_msg(String p_debug_message) {
		if (verbose == 'Y') {
			System.out.println(p_debug_message);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ch;
		char ch1 = 'e';
		
		FileUtil fu = new FileUtil();
		
		System.out.println("Welcome to FileMakerGetter");
		do {
			System.out.println("File Menu");
			System.out.println("------------");
			System.out.println("a)Add File, d)Delete File, l) list all files, s)Search Files, e)EXIT");
			String fileName;
			try {

				print_debug_msg("in try to read input");
				ch = sc.nextLine();
				ch1 = ch.charAt(0);

			} catch (StringIndexOutOfBoundsException e) {
				ch1 = 'z';
			}
			switch (ch1) {
			case 'a':
				System.out.println("Enter File Name");
				fileName = sc.nextLine();
				fu.addFile(fileName);

				print_debug_msg("after addFile");

				break;
			case 's':

				System.out.println("Enter File Name");
				fileName = sc.nextLine();
				fu.searchFile(fileName);
				break;

			case 'l':

				fu.listFiles();
				break;

			case 'd':

				System.out.println("Enter File Name");
				fileName = sc.nextLine();
				fu.deleteFile(fileName);

				break;
			case 'e':
				System.out.println("Thanks for using our app...exiting");
				break;
			default:
				System.out.println("Invalid Choice... Choice should and must be between 1-4 only");
				break;
			}
		} while (ch1 != 'e');
		sc.close();
	}

}
