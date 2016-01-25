package com.yrw.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class TestCalendar {

	public static void main(String[] args) {
		Date m = new Date( );
        System.out.println("现在是："+m.toString( ));
        Calendar n = Calendar.getInstance( );
        int year = n.get(Calendar.YEAR);
        int month = n.get(Calendar.MONTH)+1;
        int day = n.get(Calendar.DATE);
        int week = n.get(Calendar.DAY_OF_WEEK)-1;
        Date t = n.getTime ( );
        String week1 = new String("日一二三四五六");
        String week2=week1.substring(week, week+1);
        String x = new String( );
        x = "现在是："+year+"年"+month+"月"+day+"日，星期"+week2;
        System.out.println("现在是："+t);
        System.out.println(x);
        n.add(Calendar.MONTH, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(n.getTime()));
	}

}
