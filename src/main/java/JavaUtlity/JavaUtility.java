package JavaUtlity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomcount = random.nextInt(10000);
		return randomcount;
		}
		public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-ddYYYY");
		String currentdate = sim.format(date);
		return currentdate;
		}
		public String togetRequired(int days) {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-ddYYYY");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String datarequired = sim.format(cal.getTime());
		return datarequired;

}

}
