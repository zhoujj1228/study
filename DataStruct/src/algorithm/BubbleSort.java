package algorithm;

/**
 * 冒泡排序
 * @author Administrator
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		new BubbleSort().call();
	}

	private void call() {
		//统计排序次数
		int sum = 0;
		
		//定义数组
		int[] array = {3,6,1,5,3,9,2};
		
		//进行两次嵌套循环
		int leni = array.length - 1;
		int lenj = array.length - 1;
		for (int i = 0; i < leni; i++) {
			for (int j = 0; j < lenj; j++) {
				sum++;
				//进行冒泡排序
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			//因为每一次循环最后的数即最大的数已经确定，所以最后可以不进行排序，对排序最末减一
			lenj = lenj - 1;
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		//应为 ((n+1)*n)/2, 其中n为数组长度
		System.out.println("sum=" + sum);
	}
}
