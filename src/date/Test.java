package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 编写一个程序，要求用户输入自己的生日，格式
 * 为:yyyy-MM-dd
 * 然后经过程序运算，输出到今天为止一共活了
 * 多少天.
 * 再输出其出生10000天的纪念日是哪天，输出格式
 * 同样为:yyyy-MM-dd
 * @author ta
 *
 */
public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入您的生日:(yyyy-mm-dd)");
		String dateStr = scanner.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd"	
		);
		Date birth = sdf.parse(dateStr);
		Date now = new Date();
		long time = now.getTime()-birth.getTime();
		time = time/1000/60/60/24;
		System.out.println("恭喜您，已经活了"+time+"天，请继续保持!");
		time = birth.getTime()+1000L*60*60*24*10000;
		Date date = new Date(time);
		String line = sdf.format(date);
		System.out.println("您出生10000天的纪念日为:"+line);
		
		
	}
}









