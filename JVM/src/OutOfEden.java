import java.util.Scanner;

/**
 * VM args : -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
 * 测试导入对象大于Eden区,使用jstat监控
 * 结果为直接放入老年代
 * @author Jay
 * @date 2018年6月14日
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
