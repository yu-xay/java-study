package date;

import java.util.Calendar;

/**
 * void set(int field,int value)
 * 对指定的时间分量设置指定的值
 * @author ta
 *
 */
public class CalendarDemo3 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * 表示2008-08-08 20:08:08
		 */
		calendar.set(Calendar.YEAR, 2008);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DATE,3);
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 8);
		calendar.set(Calendar.SECOND, 8);
		//下面的getTime输出如果注释掉，后面的输出结果不同
		System.out.println(calendar.getTime());
		/*
		 * 上面设置日期为8号，但是set方法并非在每次
		 * 设置后就真的将时间分量该对对应值，而是在
		 * getTime时进行实际计算，但是下面的代码在
		 * 设置星期几时会影响月中的天，这会导致刚才
		 * 设置的8号被覆盖等于没做。
		 * 对此的解决办法是，当设置出现相互影响时，
		 * 可以在之前设置过后主动调用一次getTime方法
		 * 让Calendar进行一次调整运算后再设置就没有
		 * 问题了
		 */
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		System.out.println(calendar.getTime());
	}
}









