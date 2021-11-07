package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算商品促销日:
 * 输入一个商品的生产日期,格式(yyyy-MM-dd)
 * 再输入保质期的天数。
 * 然后经过程序运算输出该商品促销日期，格式
 * 也是:yyyy-MM-dd
 * 促销日计算规则:商品过期日前两周的周三
 * @author ta
 *
 */
public class Test2 {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入生产日期:");
		String dateStr = scanner.nextLine();
		
		System.out.println("请输入保质期:");
		int days = Integer.parseInt(scanner.nextLine());
		
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		//计算促销日
		//1计算过日期
		calendar.add(Calendar.DAY_OF_YEAR, days);
		//2前两周
		calendar.add(Calendar.DAY_OF_YEAR, -14);
		//3设置为当周的周三
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		
		date = calendar.getTime();
		String line = sdf.format(date);
		System.out.println("促销日为:"+line);
		
	}
}










