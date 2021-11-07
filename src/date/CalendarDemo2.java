package date;

import java.util.Calendar;

/**
 * Calendar提供了获取各时间分量信息的方法:
 * int get(int field)
 * 参数为一个int值，不同的值表示不同的时间
 * 分量，而我们无需记忆这些数字，Calendar把
 * 这些数定义为了常量。
 * @author ta
 *
 */
public class CalendarDemo2 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		//获取年
		int year = calendar.get(Calendar.YEAR);
		//获取月(月从0开始)
		int month = calendar.get(Calendar.MONTH)+1;
		/*
		 * 获取日
		 * DAY_OF_MONTH 月中的天
		 * DATE         月中的天
		 * DAY_OF_WEEK  周中的天 
		 * DAY_OF_YEAR  年中的天
		 */
		int date = calendar.get(Calendar.DATE);
		
		System.out.println(year+"-"+month+"-"+date);
		
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int m = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		System.out.println(h+":"+m+":"+s);
		
		//查看今天是今年的第几天?
		int days = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(days);
		
		//今天是周几?
		int dow = calendar.get(Calendar.DAY_OF_WEEK);
		String[] data = {"日","一","二","三","四","五","六"};
		System.out.println("周"+data[dow-1]);
		
		/*
		 * 获取指定的时间分量所允许的最大值
		 */
		days = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println(days);
		
	}
}








