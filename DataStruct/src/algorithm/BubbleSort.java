package algorithm;

/**
 * ð������
 * @author Administrator
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		new BubbleSort().call();
	}

	private void call() {
		//ͳ���������
		int sum = 0;
		
		//��������
		int[] array = {3,6,1,5,3,9,2};
		
		//��������Ƕ��ѭ��
		int leni = array.length - 1;
		int lenj = array.length - 1;
		for (int i = 0; i < leni; i++) {
			for (int j = 0; j < lenj; j++) {
				sum++;
				//����ð������
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			//��Ϊÿһ��ѭ�����������������Ѿ�ȷ�������������Բ��������򣬶�������ĩ��һ
			lenj = lenj - 1;
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		//ӦΪ ((n+1)*n)/2, ����nΪ���鳤��
		System.out.println("sum=" + sum);
	}
}
