package date;
import java.util.Date;
/**
 * java.util.Date
 * Date的每一个实例用于表示一个时间点
 * 内部维护一个long值，该值记录的时自1970年
 * 1月1日 00:00:00到当前Date表示的时间之间所
 * 经过的毫秒。
 * 由于Date存在时区以及千年虫问题，所以大部分
 * 操作时间的方法都被声明为过时的不再建议使用
 * 了。
 * @author ta
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		//默认创建表示当前系统时间
		Date date = new Date();
		System.out.println(date);
		//获取Date内部维护的long值
		long time = date.getTime();
		System.out.println(time);
		
		time = time+1000*60*60*24;
		date.setTime(time);
		System.out.println(date);
		
		date.setTime(0);
		System.out.println(date);
		
		
	}
}




