package date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 该类可以将Date与String之间互转。依靠的是
 * 一个日期格式字符串。
 * @author ta
 *
 */
public class SimleDateFormat_format {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		/*
		 * 2018-09-19 10:26:55
		 * yyyy-MM-dd HH:mm:ss
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"	
			);
		/*
		 * String format(Date date)
		 * 将给定的Date按照SDF指定的日期格式
		 * 转换为一个字符串
		 */
		String line = sdf.format(now);
		System.out.println(line);
		
	}
}







