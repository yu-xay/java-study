package date;

import java.util.Calendar;

/**
 * void add(int field,int amount)
 * ��ָ����ʱ������ۼӸ���ֵ����������ֵΪ
 * �������Ǽ�ȥ��
 * �ò�����set��ͬ������һ�κ�ͻ���ʵ����һ��
 * ���������
 * @author ta
 *
 */
public class CalendarDemo4 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * 3��5������25���Ժ�������?
		 */
		//��3��
		calendar.add(Calendar.YEAR, 3);
		//��5����
		calendar.add(Calendar.MONTH, 5);
		//��25��
		calendar.add(Calendar.DAY_OF_YEAR, 25);
		System.out.println(calendar.getTime());
		/*
		 * �鿴���ܵ����������죿
		 */
		calendar.set(
			Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		System.out.println(calendar.getTime());
		
	}
}





