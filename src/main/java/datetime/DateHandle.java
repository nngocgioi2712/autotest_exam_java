package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

public class DateHandle {
  public static long dateDiff(String startDate, String closeDate){
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    Date date1, date2;
    try {
      date1 = simpleDateFormat.parse(startDate);
      date2 = simpleDateFormat.parse(closeDate);
      long diff = date2.getTime() - date1.getTime();

      //24h/day; 60min/hour; 60 seconds/min; 1000 milliseconds/second
      long days = diff/ (24 * 60 * 60 * 1000);
      return days;
    } catch(Exception e){
      System.out.println(e.getMessage());
      return 0;
    }
  }
  public static String getCloseDate(String startDate, int months){
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    Date date1, date2;
    int days = 28+31;
    long daysInMillis;
    try{
      date1 = simpleDateFormat.parse(startDate);
      daysInMillis = (long)days * (24 * 60 * 60 * 1000);
      date2 = new Date(date1.getTime() + daysInMillis);
      return simpleDateFormat.format(date2);
    }catch (Exception e){
      System.out.println(e.getMessage());
      return "";
    }
  }
  public static String getCloseDate1(String startDate, int months){
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    Date date1, date2;
    Calendar calendarDate1 = Calendar.getInstance();
    Calendar calendarDate2 = Calendar.getInstance();
    try{
      System.out.println(calendarDate1.get(Calendar.YEAR));
      date1 = simpleDateFormat.parse(startDate);
      calendarDate1.setTime(date1);
      date2 = DateUtils.addMonths(date1, months);
      calendarDate2.setTime(date2);


      YearMonth yearMonth = YearMonth.of(calendarDate2.get(Calendar.YEAR),  calendarDate2.get(Calendar.MONTH));
      int daysInLastMonth = yearMonth.lengthOfMonth();
      return simpleDateFormat.format(date2);
    }catch (Exception e){
      System.out.println(e.getMessage());
      return "";
    }
  }
  public static void main(String[] args){
    System.out.println(dateDiff("20170220", "20211224"));
    System.out.println(getCloseDate1("20171230", 2));
  }
}
