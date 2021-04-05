package ly.java.dateutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static ThreadLocal<SimpleDateFormat> td = new ThreadLocal<SimpleDateFormat>() {
		
		protected SimpleDateFormat initialValue() {
			System.out.println("initialValue...");
			return new SimpleDateFormat("yyyy-MM-dd");
		};
	};
	
	public static synchronized Date format(String dateStr) {
		SimpleDateFormat sdf = td.get();
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
