package printdata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RecentDate {
	public static void main(String[] args) {
		DateTimeFormatter formatRecentDate = DateTimeFormatter.ofPattern("MMMM dd yyyy");
		
		System.out.print("Date: " + LocalDate.now().format(formatRecentDate));
	}
}
