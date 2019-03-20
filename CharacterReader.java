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
		
		// Path to file
		String filename = "C:\\Users\\G\\Desktop\\chars.txt";
		
		// Initializing objects to null
		File file = new File(filename);
		String str = null;
		Scanner keyboard = null;
		Scanner input = null;
		
		try {
			PrintWriter output = new PrintWriter(new FileOutputStream(file));
			keyboard = new Scanner(System.in);
				
			// User is prompted to enter string to file
			System.out.println("Welcome to the Character Reader and Writer generator!");
			System.out.println();
			System.out.print("Enter string to write on file: ");
			str = keyboard.nextLine();
			
			// Writin to file and closing writer
			output.println(str);
			output.close();
			
			// Reading file
			input = new Scanner(new FileInputStream(file));
			
			// Iterate through line(s)
			while (input.hasNextLine()) {
				// Read line with scanner
				String characters = input.nextLine();
				
				System.out.println();
				System.out.println("Characters found: ");
				// Iterate through characters of line
				for (int i = 0; i < characters.length(); i++) {
					char c = characters.charAt(i);
					// Print character with ASCII code, if provided
					if (!Character.isDigit(c))
						System.out.println(c + " - " + (int)c);
					else
						System.out.println(c + " - No ASCII for numbers");
				}
			}
		// In case file is not properly created, catch exception and quit
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please restart program.");
			System.exit(0);
		} finally {
			System.out.println();
			System.out.println("Program is closing. Have a nice day!");
		}

	}
}
