import java.util.Scanner;

/**
 * VM args : -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
 * ���Ե���������Eden��,ʹ��jstat���
 * ���Ϊֱ�ӷ��������
 * @author Jay
 * @date 2018��6��14��
 */
public class OutOfEden {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("input :");
		String nextLine = new Scanner(System.in).nextLine();
		while(!nextLine.equals("go")){
			System.out.println("input go flag :");
			nextLine = new Scanner(System.in).nextLine();
		}
		byte[] bytes = new byte[1024 * 1024 * 10];
		System.out.println(bytes);
		
		while(!nextLine.equals("end")){
			System.out.println("input end flag:");
			nextLine = new Scanner(System.in).nextLine();
		}
	}

}
