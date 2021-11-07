package socket;

import java.util.Arrays;

/**
 * 测试删除数组元素的逻辑
 * @author ta
 *
 */
public class Demo {
	public static void main(String[] args) {
		int[] allOut = {1,2,3,4,5,6,7,8,9};	
		int pw = 3;
		//将pw从数组中删除
		for(int i=0;i<allOut.length;i++) {
			if(allOut[i]==pw) {
				//将最后一个元素放在这里
				allOut[i] = allOut[allOut.length-1];
				//缩容
				allOut = Arrays.copyOf(
						allOut, allOut.length-1);
				break;
			}
		}
		
		
		
		System.out.println(Arrays.toString(allOut));
	}
}



