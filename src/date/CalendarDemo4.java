package date;

import java.util.Calendar;

/**
 * void add(int field,int amount)
 * 对指定的时间分量累加给定值。若给定的值为
 * 负数则是减去。
 * 该操作与set不同，调用一次后就会真实进行一次
 * 计算操作。
 * @author ta
 *
 */
public class CalendarDemo4 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * 3年5个月零25天以后是哪天?
		 */
		//加3年
		calendar.add(Calendar.YEAR, 3);
		//加5个月
		calendar.add(Calendar.MONTH, 5);
		//加25天
		calendar.add(Calendar.DAY_OF_YEAR, 25);
		System.out.println(calendar.getTime());
		/*
		 * 查看当周的周六是哪天？
		 */
		calendar.set(
			Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		System.out.println(calendar.getTime());
		
	}
}






