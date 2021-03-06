/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dateconverter;

import java.io.*;
import textdateparser.*;

public class DateConverter {
	public static void main(String[] args) {
		BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));   
		String textDate = null;
		String textFormat = null;

		try {
			System.out.println("Enter the date [yyyy-mm-dd]: ");    
			textDate = bufferedReader.readLine();
			System.out.println("Enter the custom format: ");
			textFormat = bufferedReader.readLine();
		} catch (Exception e) {
			System.out.println("There were problems with reading your input...");
		}
		
		System.out.println(TextDateParser.of(textDate, textFormat));
	}
}
