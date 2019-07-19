package textdateparser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.UnsupportedTemporalTypeException;

public class TextDateParser {
	public static String of(String date, String format) {		
		String dateFormatted = "";
		
		try {
			LocalDate localDate = LocalDate.parse(date);
			DateTimeFormatter datePattern = DateTimeFormatter.ofPattern(format);

			dateFormatted = datePattern.format(localDate);
		} catch (DateTimeParseException e) {
			System.out.println("The date entered do not have the right format...");
		} catch(UnsupportedTemporalTypeException e) {
			System.out.println("The format entered is not valid...");
		}

		return dateFormatted;
	}
}

