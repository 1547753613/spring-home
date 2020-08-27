package com.aaa.springboothomestay.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCompare {
	/**
	 * int类型转换为String类型
	 * @param a int类型
	 * @return
	 */
	public static String inttoString(int a) {
		String aString = null;
		aString = a+"";
		return aString;
	}
	/**
	 * 把"2019-09-20 16:09:31"类型转换为date类型
	 * 一般情况都把是jsp页面layui传回来的值进行转换
	 * @param dateStr 统一返回类型为年月日时分秒
	 * @return
	 */
	public static Date stringToDate(String dateStr) {
	    if(dateStr == null || "".equals(dateStr)){
	      return null;
	    }
	    Date date = null; 
	    //注意format的格式要与日期String的格式相匹配 
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    try { 
	      date = sdf.parse(dateStr); 
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	    } 
	    return date;
	  }
	
	
	/**参数统一为date类型
	 * 如果a>b,返回true
	 * @param a开始时间
	 * @param b结束时间
	 * @return boolean
	 */
	public static boolean compare(Date a,Date b) {
		if(a.getTime()>=b.getTime())
		{
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 在页面时就已经订好开始时间不能小于结束时间,参数统一为date类型
	 * @param begina数据库中房间的预定时间
	 * @param beginb页面获取的开始时间
	 * @param enda数据库中的房间结束时间
	 * @param endb页面获取的结束时间
	 * @return 如果客户预定的是1-5号，5号就不能被入住了，只能在六号入住
	 */
	public static boolean compares(Date begina,Date enda,Date beginb,Date endb) {
		if(begina.getTime()>endb.getTime()&&beginb.getTime()<enda.getTime())
		{
			return true;
		}else if(begina.getTime()<endb.getTime()&&beginb.getTime()>enda.getTime())
		{
			return false;
		}else {
			return false;
		}
	}
	/**
	 * 
	 * @param d 时间，date类型
	 * @param b 需要加减的时间----以小时为单位
	 * @param c “+”或者“-”
	 * @return
	 */
	public static Date hourssub(Date d,int b,String c) {
		Date date = null;
		switch (c) {
		case "+":
			date = new Date(d.getTime() + b * 60 * 60 * 1000);
			break;
		case "-":
			date = new Date(d.getTime() - b * 60 * 60 * 1000);
			break;
		default:
			date = new Date();
			break;
		}
		return date;
	}
	/**
	 * 对日期进行加减，单位为---天
	 * @param d 传过来的date类型
	 * @param b	修改的天数
	 * @param c “+”或者“-”
	 * @return 加减后的时间
	 */
	public static Date Datesub(Date d,int b,String c) {
		Date date = null;
		switch (c) {
		case "+":
			date = new Date(d.getTime() + b * 24 * 60 * 60 * 1000);
			break;
		case "-":
			date = new Date(d.getTime() - b * 24 * 60 * 60 * 1000);
			break;
		default:
			break;
		}
		return date;
	}
	
	
	
	/**
	 * 
	 * @param a date类型的.getTime()得到的long类型;
	 * @return 格式化之后的日期
	 */
	public static Date longToDate(long a) {
		Date d = new Date(a);
		return d;
	}
	
	/**
	 * 
	 * @param a开始时间
	 * @param b结束时间
	 * @return 两个时间相差天数-整天
	 */
	public int datesub(Date a,Date b) {
		long day = (a.getTime()-b.getTime())/(24*60*60*1000); 
		int c = (int)day;
		return c;
	}
	
	
	public static boolean timeEstimate(String a,int b){
		Date d  = stringToDate(a);
		String e = a.substring(0, 11);
		String h = inttoString(b);
		if(b<10){
			h = "0"+h;
		}else if (b>24) {
			h = "00";
		}
		String f = e+h+":00:00";
		if(compare(d,stringToDate(f))==true)
		{
			return true;
		}else {
			return false;
		}
	}
	

	/**
	 * 
	 * @param date 2019-13-23
	 * @return 2019-13-23 00:00:00
	 */
	public static Date Stringdate(String date) {
		date += " 00:00:00";
		return stringToDate(date);
	}
	/**
	 * 日期转换为String类型
	 * @param d Date类型
	 * @return yyyy-MM-dd
	 */
	public static String datetoString(Date d) {
		String data = null;
		SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd");
		data = sdfm.format(d);
		return data;
	}
	
	
	/**
     * date2比date1多的天数
     * @param date1    
     * @param date2
     * @return    
     */
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //不同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }
        else    //同一年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
}
