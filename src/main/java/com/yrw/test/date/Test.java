package com.yrw.test.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
 
public class Test {
	
	  public static void main(String[] args) throws ParseException {

	  Long l1 = new Long(1);
	  Long l2 = new Long(1);

		  System.out.println(l2==1);

	  	/*Calendar calendar = Calendar.getInstance();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		 calendar.add(Calendar.MONTH,-1);
		  System.out.println(sdf.format(calendar.getTime()));*/

/*//		  Calendar calendar = Calendar.getInstance();
//		  String stime="2025-10-18 17:50:23";
//		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		  Date date = sdf.parse(stime);
//		  System.out.println(date);
//		  calendar.setTime(date);
//		  System.out.println(calendar.get(Calendar.MINUTE));*/
		  
		/*  Date d=new Date();
		  System.out.println(d);
		  System.out.println(d.getTime());
		  System.out.println(date.getTime());
		  String str=date.getTime()+"";
		  System.out.println(str.substring(1, str.length()));*/
	  }
	
//    public void getTimeByDate(){
//        Date date = new Date();
//        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
//        System.out.println(df1.format(date));
//        DateFormat df2 = DateFormat.getDateTimeInstance();//可以精确到时分秒
//        System.out.println(df2.format(date));
//        DateFormat df3 = DateFormat.getTimeInstance();//只显示出时分秒
//        System.out.println(df3.format(date));
//        DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); //显示日期，周，上下午，时间（精确到秒）
//        System.out.println(df4.format(date)); 
//        DateFormat df5 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期,上下午，时间（精确到秒）
//        System.out.println(df5.format(date));
//        DateFormat df6 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT); //显示日期，上下午,时间（精确到分）
//        System.out.println(df6.format(date));
//        DateFormat df7 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //显示日期，时间（精确到分）
//        System.out.println(df7.format(date));
//    }
//    public void getTimeByCalendar(){
//        Calendar cal = Calendar.getInstance();
//        int year = cal.get(Calendar.YEAR);//获取年份
//        int month=cal.get(Calendar.MONTH);//获取月份
//        int day=cal.get(Calendar.DATE);//获取日
//        int hour=cal.get(Calendar.HOUR);//小时
//        int minute=cal.get(Calendar.MINUTE);//分           
//        int second=cal.get(Calendar.SECOND);//秒
//        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
//        System.out.println("现在的时间是：公元"+year+"年"+month+"月"+day+"日      "+hour+"时"+minute+"分"+second+"秒       星期"+WeekOfYear);
//    }
//    public static void main(String[] args) {
//        Test t=new Test();
//        t.getTimeByDate();
//        System.out.println("****************************");
//        t.getTimeByCalendar();
//    }
}