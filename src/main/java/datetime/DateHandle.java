package datetime;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHandle {
  private static DateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
  private static final long ONE_DAY_IN_MILLISECOND = 24 * 60 * 60 * 1000;

  /*
  * Calculate the total number of days from start date to close date
  * */
  public static long getDateDiff(String startDateStr, String closeDateStr){
    Date startDate, closeDate;
    long diffInMillis, diffInDay;
    try {
      startDate = simpleDateFormat.parse(startDateStr);
      closeDate = simpleDateFormat.parse(closeDateStr);
      diffInMillis = closeDate.getTime() - startDate.getTime();
      diffInDay = diffInMillis/ ONE_DAY_IN_MILLISECOND;
      return diffInDay;
    } catch(Exception e){
      System.out.println(e.getMessage());
      return 0;
    }
  }

  public static String getFirstDayOfMonth(Date date){
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.DATE, 1);
    return simpleDateFormat.format(cal.getTime());
  }

  /*
   * Return the closeDate when adding months to the startDate
   * */
  public static String getCloseDateAddMonths(String startDateStr, int months){
    Date startDate, dayOfNextStartMonth, dayOfNextEndMonth, closeDate;
    String firstDayOfNextStartMonthStr, firstDayOfNextEndMonthStr;
    long diffInDay;
    long diffInMillis;
    try{
      startDate = simpleDateFormat.parse(startDateStr);

      //get the next month of the start date
      dayOfNextStartMonth = DateUtils.addMonths(startDate, 1);
      firstDayOfNextStartMonthStr = getFirstDayOfMonth(dayOfNextStartMonth);

      //get the next month of the close date
      dayOfNextEndMonth = DateUtils.addMonths(startDate, months + 1);
      firstDayOfNextEndMonthStr = getFirstDayOfMonth(dayOfNextEndMonth);

      //calculate the days of the following months and add them to the start date
      diffInDay = getDateDiff(firstDayOfNextStartMonthStr, firstDayOfNextEndMonthStr);
      diffInMillis = diffInDay * ONE_DAY_IN_MILLISECOND;
      closeDate = new Date(startDate.getTime() + diffInMillis);

      return simpleDateFormat.format(closeDate);
    }catch (Exception e){
      System.out.println(e.getMessage());
      return "";
    }
  }
  public static void main(String[] args){
    String startDate = "19991230";
    String closeDate = "20000330";
    int monthsPlus = 2;
    System.out.println("Tong so ngay tu " + startDate + " den " + closeDate + ": "
            + getDateDiff(startDate, closeDate));
    System.out.println(startDate + " + " + monthsPlus + " month(s) = "
            + getCloseDateAddMonths(startDate, monthsPlus));
  }
}
