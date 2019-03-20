package Practise;

// George Mavroeidis , 20 March of 2019
// This program was done for practicing file I/O and exceptions handling.
// The user enters a string and it is written on a created file called chars.txt
// Once string entered, the program displays the characters with their ASCII codes
// If character is a number, it is displayed without ASCII

import java.io.*;
import java.util.*;

public class CharacterReader {

	public static void main(String[] args) {
		
		String filename = "C:\\Users\\G\\Desktop\\chars.txt";
		
		File file = new File(filename);
		String str = null;
		Scanner keyboard = null;
		Scanner input = null;
		boolean tryagain = true;
		
		do {
			try {
				PrintWriter output = new PrintWriter(new FileOutputStream(file));
				keyboard = new Scanner(System.in);
				
				System.out.println("Welcome to the Character Reader and Writer generator!");
				System.out.println();
				System.out.print("Enter string to write on file: ");
				str = keyboard.nextLine();
				
				output.println(str);
				output.close();
				
				input = new Scanner(new FileInputStream(file));
				
				while (input.hasNextLine()) {
					String characters = input.nextLine();
					
					System.out.println();
					System.out.println("Characters found: ");
					for (int i = 0; i < characters.length(); i++) {
						char c = characters.charAt(i);
						if (!Character.isDigit(c))
							System.out.println(c + " - " + (int)c);
						else
							System.out.println(c + " - No ASCII for numbers");
					}
				}
				tryagain = false;
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found. Please restart program.");
				System.exit(0);
			} finally {
				System.out.println();
				System.out.println("Program is closing. Have a nice day!");
			}
		} while (tryagain == true);

	}

}
