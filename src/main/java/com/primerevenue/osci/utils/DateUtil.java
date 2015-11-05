package com.primerevenue.osci.utils;

import java.text.SimpleDateFormat;

import java.util.Calendar;


/**
 * @author Sai Amuluru
 *
 **/
public class DateUtil {
	/**
	 * 
	 * @param aFormat
	 *            e.g. "MM/dd/yyyy"
	 * @return
	 */
	public static String getTodayDate(String aFormat)

	{

		SimpleDateFormat sdfg = new SimpleDateFormat(aFormat);
		Calendar today1 = Calendar.getInstance();
		String dt1 = sdfg.format(today1.getTime());

		return dt1;

	}

	public static String getPastOrFutureDate(String aFormat, int factor)

	{

		SimpleDateFormat sdfg = new SimpleDateFormat(aFormat);
		Calendar today1 = Calendar.getInstance();
		today1.add(Calendar.DATE, factor);
		String dt1 = sdfg.format(today1.getTime());

		return dt1;

	}

	// set start day of current month
	public static String getDayOfMonth(String aFormat)

	{

		SimpleDateFormat sdfg = new SimpleDateFormat(aFormat);
		Calendar today1 = Calendar.getInstance();
		today1.set(Calendar.DAY_OF_MONTH, 1);
		String dt1 = sdfg.format(today1.getTime());

		return dt1;

	}

	// set start day of current year
	public static String getStartOfYear(String aFormat)

	{

		SimpleDateFormat sdfg = new SimpleDateFormat(aFormat);
		Calendar today1 = Calendar.getInstance();
		today1.set(Calendar.MONTH, 0);
		today1.set(Calendar.DAY_OF_MONTH, 1);
		String dt1 = sdfg.format(today1.getTime());

		return dt1;

	}
    public static String getCurrentDate() {


        SimpleDateFormat sdfg = new SimpleDateFormat("MM/dd/yyyy");
        Calendar today1 = Calendar.getInstance();

        today1.add(Calendar.DATE, 2);
        int dow = today1.get( Calendar.DAY_OF_WEEK ) ;

        if( dow == Calendar.SATURDAY ){
            today1.add(Calendar.DATE, 2);
        }
        if( dow == Calendar.SUNDAY ){
            today1.add(Calendar.DATE, 1);
        }

        String date1 = sdfg.format(today1.getTime());




        return date1;
    }
    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        return year;
    }
}
