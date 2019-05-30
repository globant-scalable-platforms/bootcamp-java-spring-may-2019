package printdata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RecentDate {
	public static void main(String[] args) {
		DateTimeFormatter formatRecentDate = DateTimeFormatter.ISO_DATE;
		
		System.out.print("Date: ");
		System.out.print(LocalDate.now().format(formatRecentDate));
	}
}
